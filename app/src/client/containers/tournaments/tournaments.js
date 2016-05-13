import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import MatchesList from '../matches/matches-list';

require('./tournaments.scss');

class Tournament extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          tournament: props.tournament,
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {
        return (
          <div className="discipline">
              <h1>{this.state.tournament.name}</h1>
              <div>
                <MatchesList tournamentId={this.state.tournament.tournamentId} tournamentName={this.state.tournament.name}/>
              </div>
          </div>
        )
    }

    update() {
    }
}

Tournament.propTypes = {id: React.PropTypes.string};
Tournament.defaultProps = {id: null};

module.exports = Tournament
