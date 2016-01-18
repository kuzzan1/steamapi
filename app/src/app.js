/*eslint-disable no-unused-vars */
require('normalize.css');
require('styles/main.less');

import React from 'react';
import { reduxRouteComponent } from 'redux-router';
import { Router, Route } from 'react-router'
import routes from './routes';

export default class App extends React.Component {
    render() {
        return (
            <Router history={this.props.history}>
                <Route childRoutes={routes}/>
            </Router>
        );
    }
}
