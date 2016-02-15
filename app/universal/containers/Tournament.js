import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import * as PulseActions from '../actions/PulseActions';

class Tournament extends Component {
    static propTypes = {
        tournament: React.PropTypes.object
    };

    render() {
        const { tournament } = this.props;

        return (
            <div>Hej mannen: {tournament.fullName}</div>
        );
    }
}

/**
 * Expose "Smart" Component that is connect-ed to Redux
 */
export default connect(
        state => ({
        tournament: state.pulseApp.tournament
    }),
        dispatch => bindActionCreators(PulseActions, dispatch)
)(Tournament);