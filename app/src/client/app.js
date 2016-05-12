import React, { Component } from 'react';
import { render } from 'react-dom';
import { Router, Route, Link, browserHistory, IndexRoute } from 'react-router';

import DisciplineList from './containers/disciplines/discipline-list';

require('./reset.scss');
require('./main.scss');

class App extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li><Link to="/disciplines">Games</Link></li>
                </ul>

                {this.props.children}
            </div>
        )
    }
}

render(
    <Router history={browserHistory}>
        <Route path="/" component={App}>
            <Route path="disciplines">
              <IndexRoute component={DisciplineList} />
              <Route path=":disciplineId" component={DisciplineList}/>
            </Route>
        </Route>
    </Router>,
    document.querySelector('#container')
);

module.exports = App
