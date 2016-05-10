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


export function getSports() {
    return connect().then(conn => {
        return r.table('sport').run(conn).then(cursor => cursor.toArray());
    });
}

export function getTournamentsBySport(sport) {
    return connect().then(conn => {
        return r.table('tournament').getAll(sport.toString(), {index: 'discipline'}).run(conn).then(cursor => cursor.toArray());
    })
}

export function getMatchesByTournamentId(id) {
      return connect().then(conn => {
          return r.table('match').getAll(id.toString(), {index: 'tournamentId'}).run(conn).then(cursor => cursor.toArray());
      });
}

export function getMatchById(id) {
    return connect().then(conn => {
        return r.table('match').get(id.toString()).run(conn);
    })
}
