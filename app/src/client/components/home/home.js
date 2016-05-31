import React, { Component } from 'react';
import NextMatchesCard from '../../containers/next-matches-card/next-matches-card';
import NextTournamentsCard from '../../containers/next-tournaments-card/next-tournaments-card';

import "./home.scss";

class Home extends Component {
    render() {
        return (
            <div className="content-container">
              <NextMatchesCard/>
              <NextTournamentsCard/>
            </div>
        )
    }
}
module.exports = Home
