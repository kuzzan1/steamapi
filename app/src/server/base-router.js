import * as services from './services';
import Router from 'falcor-router';
import falcor from 'falcor';

class BaseRouter extends Router.createClass
    ([
       {
           route: 'disciplines',
           get: pathSet => {
               return services.getDisciplines().then(disciplines => {
                   return {
                       path: ['disciplines'],
                       value: falcor.Model.atom(disciplines)
                   }
               })
           }
       },

      {
        route: 'discipline[{keys:id}]',
        get: pathSet => {
            return services.getDisciplines()
            .then(function(disciplines){
                let results = [];
                disciplines.map(function(discipline){
                  pathSet.props.forEach(prop => {
                    results.push({
                        path: ['disciplineById', discipline.id],
                        value: falcor.Model.atom(discipline)
                    })
                  })
                })
                return results;
            })
        }
    },

    {
        route: 'tournamentsByDiscipline[{keys:disciplineName}]',
        get: pathSet => {
            return services.getTournamentsByDiscipline(pathSet.disciplineName).then(tournaments => {
                return {
                    path: ['tournamentsByDiscipline', pathSet.disciplineName],
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
    },

    {
        route: 'teamById[{keys:id}][{keys:props}]',
        get: pathSet => {
            return services.getTeamsById(pathSet.id).then(team => {
                let results = [];
                pathSet.props.forEach(prop => {
                  results.push({
                      path: ['teamById', pathSet.id, prop],
                      value: team[prop]
                  })
                })
                return results;
            })
        }
    },

    {
        route: 'teamsByDiscipline[{keys:id}]',
        get: pathSet => {
            return services.getTeamsByDiscipline(pathSet.id).then(teams => {
                return {
                    path: ['teamsByDiscipline', pathSet.id],
                    value: falcor.Model.atom(teams)
                }
            })
        }
    },

    {
        route: 'playersByTeamId[{keys:id}]',
        get: pathSet => {
            return services.playerByTeamId(pathSet.id).then(players => {
                return {
                    path: ['playersByTeamId', pathSet.id],
                    value: falcor.Model.atom(players)
                }
            })
        }
    },

    {
        route: 'playersByDiscipline[{keys:id}]',
        get: pathSet => {
            return services.getPlayersByDiscipline(pathSet.id).then(players => {
                return {
                    path: ['playersByDiscipline', pathSet.id],
                    value: falcor.Model.atom(players)
                }
            })
        }
    },

  ])

  {
        constructor() {
            super();
        }
    }


module.exports = BaseRouter;
