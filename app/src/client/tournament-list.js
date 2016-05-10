import React from 'react';
import Falcor from 'falcor';
import model from './model';

class TournamentList extends React.Component {
    constructor() {
        super()
        this.state = {tournaments: {}}
    }

    componentWillMount() {
        this.update()
    }

    render() {
        var tournaments = Object.keys(this.state.tournaments).map(idx => {
            return (
                <li key={idx}>
                    <span>{this.state.tournaments[idx].fullName}</span>
                    <span>{this.state.tournaments[idx].location}</span>
                </li>
            )
        })
        return (
            <ul>
                {tournaments}
            </ul>
        )
    }

    update() {
        model.get(['tournamentById', '569f9a39150ba029528b47bc', ['fullName','location','online']]).then( response => this.setState({tournaments: response.json.tournamentById}));
    }
}

module.exports = TournamentList
