var React = require('react');
import TournamentList from './tournament-list.jsx';

module.exports = class extends React.Component {

    render() {
        return (
            <div>
                <TournamentList/>
            </div>
        )
    }
}