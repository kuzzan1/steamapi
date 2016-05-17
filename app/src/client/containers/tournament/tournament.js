import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Matches from '../matches/matches';

class Tournament extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          id: props.id || props.params.id,
          maps: []
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {
      const maps = this.state.maps ? this.state.maps.map(map => {
          return (
              <div key={map}>
                  <div>{map}</div>
              </div>
          )
      }) : [];
      return (
        <div className="discipline">
            <h1>{this.state.name}</h1>
            <div>
              {this.state.description}
            </div>
            <div>
              <h2> Maps </h2>
              {maps}
            </div>
            <h2> Matches </h2>
            <Matches tournamentId={this.state.id} />
        </div>
      )
    }

    update() {
      model.get(['tournamentById', this.state.id]).then( response => {
        this.setState(response.json.tournamentById[this.state.id]);
      });
    }
}

Tournament.propTypes = {id: React.PropTypes.string};
Tournament.defaultProps = {id: null};

module.exports = Tournament
