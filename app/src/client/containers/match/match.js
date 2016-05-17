import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Team from '../team/team';

class Match extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          id: props.id || props.params.id,
          opponents: []
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {

      const teams = this.state.opponents ? this.state.opponents.map(opponent => {        
          return (
              <div>
                    <Team participant={opponent.participant} />
              </div>
          )
      }) : [];

      return (
        <div className="discipline">
            <h2>{this.state.name}</h2>
            <div>
              <h2> Teams </h2>              
              {teams}
            </div>
        </div>
      )
    }

    update() {
      model.get(['matchById', this.state.id]).then( response => {
        this.setState(response.json.matchById[this.state.id]);
      });
    }
}

module.exports = Match
