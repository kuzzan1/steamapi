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
        route: 'discipline[{keys:id}][{keys:props}]',
        get: pathSet => {
            return services.getDisciplines()
            .then(function(disciplines){
                let results = [];
                disciplines.map(function(discipline){
                  pathSet.props.forEach(prop => {
                    results.push({
                        path: ['disciplineById', discipline.id, prop],
                        value: discipline[prop]
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
    }
  ])

  {
        constructor() {
            super();
        }
    }


module.exports = BaseRouter;
