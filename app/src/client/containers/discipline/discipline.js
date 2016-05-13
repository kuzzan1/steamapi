import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import TournamentList from '../tournaments/tournament-list';
import { Link } from 'react-router'

require('./discipline.scss');

class Discipline extends React.Component  { 
    constructor(props) {
        super(props)
        this.state = {
          id: props.id || props.params.id
        }
    }
    componentWillMount() {
        this.update()
    }

    componentWillReceiveProps(nextProps) { 
      this.state = {id: nextProps.params.id}
      this.update();
    }

    render() {
        return (
          <div className="discipline">
              <Link to={`/discipline/${this.state.id}`} ><h1>{this.state.fullName}</h1></Link>
              <div>
                <TournamentList disciplineId={this.state.id} disciplineName={this.state.name}/>
              </div>
          </div>
        )
    }

    update() {
      model.get(['disciplineById', this.state.id]).then( response => {         
        this.setState(response.json.disciplineById[this.state.id]);
      });
    }
}

Discipline.propTypes = {id: React.PropTypes.string};
Discipline.defaultProps = {id: null};

module.exports = Discipline
