import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Team from '../team/team';

class Teams extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
           participants: props.participants
        }
    }
   
    render() {    
        var matches = Object.keys(this.state.participants).map(idx => {
            return (                
                <div key={idx}>
                    <Team participant={idx} />
                </div>
            )
        })
        return (
            <div>
              {matches}
            </div>            
        )
    }
}

module.exports = Teams
