import React, { PropTypes, Component } from 'react';
import { IndexLink, Link } from 'react-router';

export default class Header extends Component {
    render() {
        return (
            <div>
                <header className='header'>
                    <h1>Toornament API Test</h1>
                    <div className='main-menu'>
                        <IndexLink to='/' activeClassName='active'>All Events</IndexLink>
                        <Link to='/my-events' activeClassName='active'>My Events</Link>
                        <Link to='/other-events' activeClassName='active'>Other Events</Link>
                    </div>
                </header>
            </div>
        );
    }
}