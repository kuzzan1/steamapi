import React from 'react';
import TournamentList from './tournaments/tournament-list';
import DisciplineList from './disciplines/discipline-list';

module.exports = class extends React.Component {

    render() {
        return (
            <div>
                <DisciplineList />
                <TournamentList/>
            </div>
        )
    }
}
