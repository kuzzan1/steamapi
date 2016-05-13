import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Discipline from '../discipline/discipline';

class Disciplines extends React.Component {
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
                <div key={idx}>
                    <Discipline id={this.state.disciplines[idx].id} />
                </div>
            )
        })
        return (
            <div>
              <h1>Disciplines</h1>
              <div className="discipline-list">
                  {disciplines}
              </div>
            </div>
        )
    }

    update() {
        model.get(['disciplines']).then( response => this.setState({disciplines: response.json.disciplines}));
    }
}

module.exports = Disciplines
