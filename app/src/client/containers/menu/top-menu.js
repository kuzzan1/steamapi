import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import { Link, IndexLink } from 'react-router'

require('./top-menu.scss')

class TopMenu extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          disciplines: {}
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {
        var disciplines = Object.keys(this.state.disciplines).map(idx => {
            return (
              <li key={idx}>
                <Link to={`/discipline/${this.state.disciplines[idx].id}`} activeClassName='top-menu--active' >{this.state.disciplines[idx].name}</Link>
              </li>
            )
        })

        return (
          <div id="top-menu">
            <ul>
              <li>

                <IndexLink to={'/'} activeClassName='top-menu--active'>
                  <span>Home</span>
                </IndexLink>

              </li>
              <li className="top-menu--has-children">
                <Link to={'/discipline'} activeClassName='top-menu--active'>
                  <span>
                    Disciplines
                  </span>
                </Link>
                <ul>
                  {disciplines}
                </ul>
              </li>
              <li>
                <IndexLink to={'tournaments'} activeClassName='top-menu--active'>
                  <span>Tournaments</span>
                </IndexLink>
              </li>
            </ul>
          </div>
        )
    }

    update() {
        model.get(['disciplines']).then( response => this.setState({disciplines: response.json.disciplines}));
    }
}

module.exports = TopMenu
