import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './app';
import { browserHistory } from 'react-router'
import Parse from 'init-parse'


ReactDOM.render(<App history={browserHistory}/>, document.getElementById('root'));
