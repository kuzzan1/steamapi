import React from 'react';
import ReactDom from 'react-dom';
import App from './app';

require('./reset.scss');
require('./main.scss');

ReactDom.render(
    <App />,
    document.querySelector('#container')
);
