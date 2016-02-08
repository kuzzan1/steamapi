import React, { Component } from 'react';

export default class EventItem extends Component {
    render() {
        const { event } = this.props;

        return (
            <li className="event" data-tournament-id={event.tournamentId}>
                <div className="date">{event.dateStart} - {event.dateEnd}</div>
                <div className="name">{event.name}</div>
                <div className="location">{event.location}</div>
            </li>
        );
    }
}