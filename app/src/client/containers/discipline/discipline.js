import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Tournaments from '../tournaments/tournaments';
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
              <Link to={`/discipline/${this.state.id}`} ><h1>{this.state.name}</h1></Link>
              <div>
                <Tournaments disciplineId={this.state.id} disciplineName={this.state.name} displayInline={true} />
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
