import React, { Component } from 'react';
import { Link } from 'react-router';
import moment from 'moment';

export default class EventItem extends Component {
    render() {
        const { event } = this.props;
        let tournamentStatus = 'event ';

        if(moment(event.dateStart).isAfter(new Date()) && moment(event.dateEnd).isAfter(new Date())){
            tournamentStatus += 'upcoming';
        } else if (moment(event.dateEnd).isAfter(new Date())) {
            tournamentStatus += 'ongoing';
        } else {
            tournamentStatus += 'completed';
        }

        return (
            <Link to={`/tournament/${event.tournamentId}`}>
                <li className={tournamentStatus} data-tournament-id={event.tournamentId}>
                    <div className="date">{event.dateStart} - {event.dateEnd}</div>
                    <div className="name">{event.name}</div>
                    <div className="discipline">{event.discipline}</div>
                    <div className="location">{event.location}</div>
                </li>
            </Link>
        );
    }
}