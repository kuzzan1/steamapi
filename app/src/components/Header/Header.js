require('normalize.css');
require('./Header.less');

import React from 'react';

class HeaderComponent extends React.Component {
	render(){
        //Split this into components
        return (
            <header id="header"> 
                <div className="header-wrapper">
                    <h1 className="logo"></h1>
                    <input className="id-input" type="text" placeholder="Input steamid or something" />
                    <input className="submit-button" type="submit" value="Submit" />
                </div>
            </header>
        );
    }
}

HeaderComponent.propTypes = {

};

HeaderComponent.defaultProps = {

};

export default HeaderComponent;