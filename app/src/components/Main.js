/* global $ */
require('normalize.css');
require('styles/App.less');


import React from 'react';
import HelloWorld from './HelloWorld';

class AppComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            steamid: props.steamid,
            personaname: props.personaname,
            avatarfull: props.avatarfull,
            timecreated: props.timecreated
        };
    }
    
    componentDidMount() {
        $.ajax({
            url: '/images/test.json',
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({
                    steamid: data.response.players[0].steamid,
                    personaname: data.response.players[0].personaname,
                    avatarfull: data.response.players[0].avatarfull,
                    timecreated: data.response.players[0].timecreated
                });
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(data, status, err.toString());
            }.bind(this)
        });
    }
    
	render(){
        return <HelloWorld steamid={this.state.steamid} personaname={this.state.personaname} timecreated={this.state.timecreated} avatarfull={this.state.avatarfull} />
    }
}

AppComponent.propTypes = { 
    steamid: React.PropTypes.number,
    personaname: React.PropTypes.string,
    avatarfull: React.PropTypes.string,
    timecreated: React.PropTypes.number
};
AppComponent.defaultProps = {
    steamid: 123,
    personaname: 'Jörgen Pettersson',
    avatarfull: 'no-image',
    timecreated: 1238056572 
};

export default AppComponent;
