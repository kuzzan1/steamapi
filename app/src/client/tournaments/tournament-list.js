import React from 'react';
import Falcor from 'falcor';
import model from '../model';

class TournamentList extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          tournaments: [],
          disciplineId: props.disciplineId,
          disciplineName: props.disciplineName
        }
    }

    componentWillMount() {
        this.update()
    }

    render() {
        var tournaments = this.state.tournaments.map(tournament => {

            return (
                <div key={tournament.tournamentId}>
                    <span>{tournament.fullName}</span>
                    <span>{tournament.location}</span>
                </div>
            )
        })
        return (
          <div>
            <h2>{this.state.disciplineName} Tournaments</h2>
            <div className="discipline__tournaments" >
                {tournaments}
            </div>
          </div>
        )
    }

    update() {
        model.get(['tournamentsByDiscipline', this.state.disciplineId, ['fullName','location','online']]).then( response => {
          console.log(response.json.tournamentsByDiscipline[this.state.disciplineId]);
          this.setState({tournaments: response.json.tournamentsByDiscipline[this.state.disciplineId]});
        });
    }
}

TournamentList.propTypes = {disciplineId: React.PropTypes.string};
TournamentList.defaultProps = {disciplineId: ""};


module.exports = TournamentList
