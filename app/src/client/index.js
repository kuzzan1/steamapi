import React from 'react';
import ReactDom from 'react-dom';
import Tournament from './tournament';

require('./main.scss');

ReactDom.render(
    <Tournament/>,
    document.querySelector('#tournament')
);
