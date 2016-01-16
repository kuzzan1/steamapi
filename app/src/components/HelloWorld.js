var moment = require('moment');

import React from 'react';

class HelloWorld extends React.Component {
    convertToTimeOrSomething() {
        return moment.unix(this.props.timecreated).fromNow();
    }
    
    render() {
        return <h1>
            <img src={this.props.avatarfull} />
            Hello {this.props.personaname} ({this.props.steamid}), your account was
            created {this.convertToTimeOrSomething()}.
        </h1>;
    }
}

export default HelloWorld;