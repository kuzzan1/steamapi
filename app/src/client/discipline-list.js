import React from 'react';
import Falcor from 'falcor';
import model from './model';

class DisciplineList extends React.Component {
    constructor() {
        super()
        this.state = {disciplines: {}}
    }

    componentWillMount() {
        this.update()
    }

    render() {
        var disciplines = Object.keys(this.state.disciplines).map(idx => {
            return (
                <li key={idx}>
                    <span>{this.state.disciplines[idx].fullName}</span>
                </li>
            )
        })
        return (
            <div>
            <h1>Disciplines!</h1>
              <ul>
                  {disciplines}
              </ul>
            </div>
        )
    }

    update() {
        model.get(['disciplines']).then( response => this.setState({disciplines: response.json.disciplines}));
    }
}

module.exports = DisciplineList
