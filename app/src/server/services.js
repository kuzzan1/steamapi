import r from 'rethinkdb';


function connect() {
    return r.connect({
        host: '176.58.126.231',
        port: 28015,
        authKey: "bajskorv",
        db: "data"
     });
}

export function getTournaments() {
    return connect().then(conn => {
        return r.table('tournament').orderBy(r.desc('dateStart')).run(conn);
    });
}

export function getNextXTournaments(limit) {
  return connect().then(conn => {
    return r.table('tournament').orderBy(r.asc('dateStart')).filter(tournament => {
      return r.ISO8601(tournament('dateStart'), {defaultTimezone: 'Z'}).date().gt(r.now().date());
    }).limit(+limit[0]).run(conn);
  }).catch(error => {
    console.log(error);
  })
}

export function getNextXMatches(limit) {
  return connect().then(conn => {
    return r.table('match').hasFields('date').orderBy(r.asc('date')).filter(r.ISO8601(r.row('date')).date().gt(r.now().date())).limit(+limit[0]).run(conn);
  }).catch(error => {
    console.log(error);
  })
}

export function getDisciplines() {
    return connect().then(conn => {
        return r.table('discipline').run(conn).then(cursor => cursor.toArray());
    });
}

export function getDisciplineById(id) {
    return connect().then(conn => {
        return r.table('discipline').get(id.toString()).run(conn);
    });
}

export function getTournamentById(id) {
    return connect().then(conn => {
        return r.table('tournament').get(id.toString()).run(conn);
    });
}


export function getTournamentsByDiscipline(discipline) {
    console.log(discipline);
    return connect().then(conn => {
        return r.table('tournament').getAll(discipline.toString(), {index: 'discipline'}).orderBy(r.desc('dateStart')).run(conn).then(cursor => cursor.toArray());
    })
}

export function getMatchesByTournamentId(id) {
      return connect().then(conn => {
          return r.table('match').getAll(id.toString(), {index: 'tournamentId'}).orderBy(r.desc('date')).run(conn).then(cursor => cursor.toArray());
      });
}

export function getMatchById(id) {
    return connect().then(conn => {
        return r.table('match').get(id.toString()).run(conn);
    })
}

export function getTeamsByDiscipline(id) {
    return connect().then(conn => {
        return r.table('team').getAll(id.toString(), {index: 'discipline'}).run(conn).then(cursor => cursor.toArray());
    })
}

export function getTeamsById(id) {
    return connect().then(conn => {
        return r.table('team').get(id.toString()).run(conn);
    })
}

export function playerByTeamId(id) {
    return connect().then(conn => {
        return r.table('player').getAll(id.toString(), {index: 'teamId'}).run(conn).then(cursor => cursor.toArray());
    })
}

export function getPlayersByDiscipline(id) {
    return connect().then(conn => {
        return r.table('player').getAll(id.toString(), {index: 'discipline'}).run(conn).then(cursor => cursor.toArray());
    })
}
