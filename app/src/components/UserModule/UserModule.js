require('normalize.css');
require('./UserModule.less');

import React from 'react';

class UserModule extends React.Component {
	render(){
        return (
            <div id="user-module">
                User Module
            </div>
        );
    }
}

UserModule.propTypes = {

};

UserModule.defaultProps = {

};

export default UserModule;