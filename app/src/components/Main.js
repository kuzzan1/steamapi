require('normalize.css');
require('styles/App.css');

import React from 'react';
import HelloWorld from './HelloWorld';

class AppComponent extends React.Component {
	render(){
        return <HelloWorld text="ES6" />
    }
}

AppComponent.defaultProps = {
};

export default AppComponent;
