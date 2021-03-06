import React, { Component } from 'react';
import { render } from 'react-dom';
import { Router, Route, Link, browserHistory, IndexRoute, Redirect } from 'react-router';

import Disciplines from './containers/disciplines/disciplines';
import Discipline from './containers/discipline/discipline';
import Tournaments from './containers/tournaments/tournaments';
import Tournament from './containers/tournament/tournament';

import Matches from './containers/matches/matches';
import Match from './containers/match/match';

import TopMenu from './containers/menu/top-menu';
import Home from './components/home/home';

require('./reset.scss');
require('./main.scss');

class App extends Component {
    render() {
        return (
            <div>
                <TopMenu />
                {this.props.children}
            </div>
        )
    }
}

class PageNotFound extends Component {
    render() {
        return (
            <div>
                <h1>Page Not Found.</h1>
                <p>Go to <Link to="/">Home Page</Link></p>
            </div>
        )
    }
}

render(
    <Router history={browserHistory}>
        <Route path='/' component={App}>

          <IndexRoute component={Home} />

          <Route path='home' component={Home} />

          <Route path="disciplines">
            <IndexRoute component={Disciplines} />
            <Route path=":id" component={Discipline}/>
          </Route>

          <Route path="discipline">
            <IndexRoute component={Disciplines} />
            <Route path=":id" component={Discipline} />
          </Route>

          <Route path="tournaments">
            <IndexRoute component={Tournaments} />
          </Route>

          <Route path="tournament/:id" component={Tournament}></Route>

          <Route path="matches">
            <IndexRoute component={Matches} />
          </Route>

          <Route path="match/:id" component={Match}></Route>          
          
          <Route path="*" component={PageNotFound} />
        </Route>
    </Router>,
    document.querySelector('#container')
);

module.exports = App
