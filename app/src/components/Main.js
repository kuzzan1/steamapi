require('normalize.css');
require('styles/App.less');


import React from 'react';
import Header from './Header/Header';
import Sidebar from './Sidebar/Sidebar';
import MainContent from './MainContent/MainContent';

class AppComponent extends React.Component {
	render(){
        return (
        <div className="wrapper">
            <Sidebar></Sidebar>
            <Header></Header>
            <MainContent></MainContent>
        </div>
        );
    }
}

AppComponent.propTypes = {

};

AppComponent.defaultProps = {

};

export default AppComponent;
