import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import Header from '../components/Header';
import EventList from '../components/EventList';

import * as PulseActions from '../actions/PulseActions';

class PulseApp extends Component {
    static propTypes = {
        events: React.PropTypes.array,
        error: React.PropTypes.any
    };

    render() {
        return (
            <div className="container">
                <Header/>
                {this.props.index}
                {this.props.myEvents}
            </div>
        );
    }
}

/**
 * Expose "Smart" Component that is connect-ed to Redux
 */
export default connect(
        state => ({
        events: state.pulseApp.events,
        error: state.pulseApp.error
    }),
        dispatch => bindActionCreators(PulseActions, dispatch)
)(PulseApp);
