import React from 'react';
import Header from './header/index';
import Sidebar from './sidebar/index';

require('./root.less');

export default class RootComponent extends React.Component {
    render() {
        return (
            <div id="wrapper">
                <Sidebar />
                <Header />
                {this.props.children}
            </div>
        );
    }
}
