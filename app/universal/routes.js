import React from 'react';
import { Route, IndexRoute } from 'react-router';

import PulseApp from './containers/PulseApp';
import MyEvents from './containers/MyEvents';
import Index from './containers';

export default (
    <Route path='/' component={PulseApp}>
        <IndexRoute components={{index: Index}}/>
        <Route path='my-events' components={{myEvents: MyEvents}}/>
    </Route>
);