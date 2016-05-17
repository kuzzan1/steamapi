import React from 'react';
import Falcor from 'falcor';
import model from '../../model';

class Team extends React.Component {
    constructor(props) {
        super(props)
        this.state = {          
          participant: props.participant
        }
    }
    render() {
      
      return (
        <div className="discipline">
            <div>
              {this.state.participant.name}
            </div>
        </div>
      )
    }
}

module.exports = Team
