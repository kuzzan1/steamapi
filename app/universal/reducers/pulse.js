import * as actions from '../constants/ActionTypes';

const initialState = {
  isWorking: false,
  error: null,
  events: []
};

export default function pulses(state = initialState, action = null) {
  switch (action.type) {
    case actions.EDIT_EVENT_REQUEST:
      return Object.assign({}, state, {
        isWorking: true,
        error: null
      });

    case actions.EDIT_EVENT_SUCCESS:
      return Object.assign({}, state, {
        isWorking: false,
        error: null,
        events: state.events.map(event =>
          event.tournamentId === action.event.tournamentId ?
            action.event :
            event
        )
      });

    case actions.EDIT_EVENT_FAILURE:
      return Object.assign({}, state, {
        isWorking: false,
        error: action.error,
      });

    default:
      return state;
  }
}
