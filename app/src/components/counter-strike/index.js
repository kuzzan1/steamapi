import React from 'react';

import CsGoUpcomingMatches from './cs-upcoming-matches/index';

export default class CounterStrike extends React.Component {
    render() {
        return (
            <div className="page counter-strike">
                <h1>Counter Strike: Global ÖFFENSIVE</h1>
                <CsGoUpcomingMatches size="medium" url="http://localhost:8090/app/getTopLiveGame" />
            </div>
        );
    }
}
