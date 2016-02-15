import r from 'rethinkdb';
import config from 'config';
import xss from 'xss';

function connect() {
    return r.connect(config.get('rethinkdb'));
}

export function liveUpdates(io) {
    console.log('Setting up listener...');
    connect()
        .then(conn => {
            r
                .table('tournament')
                .changes().run(conn, (err, cursor) => {
                    console.log('Listening for changes...');
                    cursor.each((err, change) => {
                        console.log('Change detected', change);
                        io.emit('event-change', change);
                    });
                });
        });
}

export function getEvents() {
    return connect()
        .then(conn => {
            return r
                .table('tournament')
                .orderBy(r.desc('dateStart')).run(conn)
                .then(cursor => cursor.toArray());
        });
}

export function getTournament(tournamentId) {
    return connect()
        .then(conn => {
            return r
                .table('tournament')
                .get(tournamentId).run(conn);
        });
}