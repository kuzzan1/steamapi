import React from 'react';

class HelloWorld extends React.Component {
    render() {
        return <h1>Hello from { this.props.text }!</h1>;
    }
}

export default HelloWorld;