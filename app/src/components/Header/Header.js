require('./Header.less');

import React from 'react';

class HeaderComponent extends React.Component {
	render(){
        //Split this into components
        return (
            <header id="header"> 
                <div className="header-wrapper">
                    <h1 className="logo"></h1>
                    <nav className="game-menu">
                        <ul className="game-menu-list">
                            <li className="game cs">CS:GO</li>
                            <li className="game dota">Dota 2</li>
                            <li className="game smite">Smite</li>
                            <li className="game lol">League of Legends</li>
                        </ul>
                    </nav>
                </div>
            </header>
        );
    }
}

//<input className="id-input" type="text" placeholder="Input steamid or something" />
//<input className="submit-button" type="submit" value="Submit" />

HeaderComponent.propTypes = {

};

HeaderComponent.defaultProps = {

};

export default HeaderComponent;