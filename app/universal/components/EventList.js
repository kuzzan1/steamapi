import React, {PropTypes, Component} from 'react';

import EventItem from './EventItem';

export default class EventList extends Component {
    static propTypes = {
        events: PropTypes.array.isRequired
    };

    render() {
        const { events } = this.props;

        let list;
        let tournaments;

        let x = true;

        if(x) {
            tournaments = events.filter(row => row.discipline === 'counterstrike_go');
        } else {
            tournaments = events.filter(row => row.discipline === 'leagueoflegends');
        }

        list = tournaments.map((event, key) =>
            <EventItem key={key} row={key} event={event}></EventItem>
        );

        return (
            <section>
                <ul className="event-list">
                    {list}
                </ul>
            </section>
        );
    }
}