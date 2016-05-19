import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Match from '../match/match';
import MatchCard from '../../components/match-card/match-card';

require('./matches.scss');

class Matches extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
           tournamentId: props.tournamentId || props.params.tournamentId,
            matches: {}
        }
    }

    componentWillMount() {
        this.update()
    }

    render() {
        var matches = Object.keys(this.state.matches).map(idx => {
            return (
              <MatchCard key={idx} match={this.state.matches[idx]} />
            )
        })
        return (
            <div className="match-card-container" >
              {matches}
            </div>
        )
    }

    update() {
        model.get(['matchesByTournamentId', this.state.tournamentId]).then( response => {
            this.setState({matches: response.json.matchesByTournamentId[this.state.tournamentId]})
        });
    }
}

module.exports = Matches
