import {
  LOAD_EVENTS_REQUEST, LOAD_EVENTS_SUCCESS, LOAD_EVENTS_FAILURE,
  ADD_EVENT_REQUEST, ADD_EVENT_SUCCESS, ADD_EVENT_FAILURE,
  DELETE_EVENT_REQUEST, DELETE_EVENT_SUCCESS, DELETE_EVENT_FAILURE,
  EDIT_EVENT_REQUEST, EDIT_EVENT_SUCCESS, EDIT_EVENT_FAILURE,
  SET_USER_ID
} from '../constants/ActionTypes';

const initialState = {
  isWorking: false,
  error: null,
  events: []
};

export default function pulses(state = initialState, action = null) {
  switch (action.type) {
    case EDIT_EVENT_REQUEST:
      return Object.assign({}, state, {
        isWorking: true,
        error: null
      });

    case EDIT_EVENT_SUCCESS:
      return Object.assign({}, state, {
        isWorking: false,
        error: null,
        events: state.events.map(event =>
          event.tournamentId === action.event.tournamentId ?
            action.event :
            event
        )
      });

    case EDIT_EVENT_FAILURE:
      return Object.assign({}, state, {
        isWorking: false,
        error: action.error,
      });

    default:
      return state;
  }
}
