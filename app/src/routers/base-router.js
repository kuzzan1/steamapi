import * as services from '../services';
import Router from 'falcor-router';
import falcor from 'falcor';

class BaseRouter extends Router.createClass
    ([
      {
        route: 'sportByName[{keys:sportId}][{keys:props}]',
        get: pathSet => {
            return services.getSports()
            .then(function(sports){
                let results = [];
                sports.map(function(sport){
                  pathSet.props.forEach(prop => {
                    results.push({
                        path: ['sportById', sport.id, prop],
                        value: sport[prop]
                    })
                  })
                })
                return results;
            })
        }
    },

    {
        route: 'tournamentsBySport[{keys:sportName}]',
        get: pathSet => {
            return services.getTournamentsBySport(pathSet.sportName).then(tournaments => {
                return {
                    path: ['tournamentsBySport', pathSet.sportName],
                    value: falcor.Model.atom(tournaments)
                }
            })
        }
    },
    {
        route: 'tournamentById[{keys:tournamentId}][{keys:props}]',
        get: pathSet => {
            return services.getTournaments()
            .then(function(tournaments){
                let results = [];
                tournaments.map(function(tournament){
                  pathSet.props.forEach(prop => {
                    results.push({
                        path: ['tournamentById', tournament.tournamentId, prop],
                        value: tournament[prop]
                    })
                  })
                })
                return results;
            })
        }
    },
    {
        route: 'matchesByTournamentId[{keys:id}]',
        get: pathSet => {
            return services.getMatchesByTournamentId(pathSet.id).then(matches => {
                return {
                    path: ['matchesByTournamentId', pathSet.id],
                    value: falcor.Model.atom(matches)
                }
            })
        }
    },
    {
        route: 'matchById[{keys:id}]',
        get: pathSet => {
            return services.getMatchById(pathSet.id).then(match => {
                return {
                    path: ['matchById', pathSet.id],
                    value: falcor.Model.atom(match)
                }
            })
        }
    }
  ])

  {
        constructor() {
            super();
        }
    }


module.exports = BaseRouter;
