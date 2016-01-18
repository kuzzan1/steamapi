require('./header.less');

import React from 'react';
import { Link } from 'react-router'

class HeaderComponent extends React.Component {
    constructor(props){
        super(props);
    }

	render(){
        //Split this into components
        return (
            <header id="header">
                <div className="header-wrapper">
                    <Link to="/">
                        <h1 className="logo"></h1>
                    </Link>
                    <nav className="game-menu">
                        <ul className="game-menu-list">
                            <Link to="/cs" className="game cs" activeClassName="active">CS:GO</Link>
                            <Link to="/dota2" className="game dota" activeClassName="active">Dota 2</Link>
                            <Link to="/smite" className="game smite" activeClassName="active">Smite</Link>
                            <Link to="/lol" className="game lol" activeClassName="active">League of Legends</Link>
                        </ul>
                    </nav>
                </div>
            </header>
        );
    }
}

//<input className="id-input" type="text" placeholder="Input steamid or something" />
//<input className="submit-button" type="submit" value="Submit" />

export default HeaderComponent;