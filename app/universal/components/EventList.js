import React, {PropTypes, Component} from 'react';

import EventItem from './EventItem';

export default class EventList extends Component {
    static propTypes = {
        events: PropTypes.array.isRequired
    };

    render() {
        const { events } = this.props;

        const myEvents = events;
        let list;

        list = myEvents.map((event, key) =>
            <EventItem key={key} event={event}></EventItem>
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