import React from 'react';
import { Route, IndexRoute } from 'react-router';

import PulseApp from './containers/PulseApp';
import MyEvents from './containers/MyEvents';
import Tournament from './containers/Tournament';
import Index from './containers';

export default (
    <Route path='/' component={PulseApp}>
        <IndexRoute components={{index: Index}}/>
        <Route path='tournaments' components={{myEvents: MyEvents}}/>
        <Route path='tournament/:id' components={{tournament: Tournament}}/>
    </Route>
);