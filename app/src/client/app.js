import React from 'react';
import TournamentList from './tournament-list';
import DisciplineList from './discipline-list';

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
