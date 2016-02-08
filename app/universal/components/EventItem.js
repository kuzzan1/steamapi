import React, { Component } from 'react';

export default class EventItem extends Component {
    render() {
        const { event } = this.props;

        return (
            <li className="event">
                <div className="date">{event.dateStart} - {event.dateEnd}</div>
                <div className="name">{event.name}</div>
                <div className="location">{event.location}</div>
                <div className="id">{event.tournamentId}</div>
            </li>
        );
    }
}