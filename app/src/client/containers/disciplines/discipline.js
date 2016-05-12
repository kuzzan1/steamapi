import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import TournamentList from '../tournaments/tournament-list';

require('./disciplines.scss');

class Discipline extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          discipline: props.discipline,
          copyrights: props.discipline.copyrights,
          id: props.discipline.id,
          fullName: props.discipline.fullName,
          name: props.discipline.name,
          shortName: props.discipline.shortName
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {

        return (
          <div className="discipline">
              <h1>{this.state.fullName}</h1>
              <div>
                <TournamentList disciplineId={this.state.id} disciplineName={this.state.name}/>
              </div>
          </div>
        )
    }

    update() {
    }
}

Discipline.propTypes = {id: React.PropTypes.string};
Discipline.defaultProps = {id: null};

module.exports = Discipline
