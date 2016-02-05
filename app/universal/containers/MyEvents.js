import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import EventList from '../components/EventList';

import * as PulseActions from '../actions/PulseActions';

class MyEvents extends Component {
  static propTypes = {
    events: React.PropTypes.array
  };

  render() {
    return (
      <EventList events={this.props.events} />
    );
  }
}

/**
 * Expose "Smart" Component that is connect-ed to Redux
 */
export default connect(
  state => ({
    events: state.pulseApp.events
  }), 
  dispatch => bindActionCreators(PulseActions, dispatch)
)(MyEvents);