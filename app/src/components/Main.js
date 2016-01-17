///* global $ */
require('normalize.css');
require('styles/App.less');


import React from 'react';
import Header from './Header/Header';
import Sidebar from './Sidebar/Sidebar';

class AppComponent extends React.Component {
	render(){
        return (
        <div className="wrapper">
            <Sidebar></Sidebar>
            <Header></Header>
        </div>
        );
    }
}

AppComponent.propTypes = {

};

AppComponent.defaultProps = {

};

export default AppComponent;
