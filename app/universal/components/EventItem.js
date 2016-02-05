import React, { Component } from 'react';

export default class EventItem extends Component {
    render() {
        const { event } = this.props;

        return (
            <li>{event.name}</li>
        );
    }
}