import * as types from '../constants/ActionTypes';
import request from 'superagent';

const serverUrl = '';
const eventsUrl = `${serverUrl}/api/0/events`;

export function loadEvents() {
    return dispatch => {
        dispatch(loadEventsRequest());
        return request
            .get(eventsUrl)
            .set('Accept', 'application/json')
            .end((err, res) => {
                if (err) {
                    dispatch(loadEventsFailure(err));
                } else {
                    dispatch(loadEventsSuccess(res.body));
                }
            });
    };
}

export function loadEventsRequest() {
    return {
        type: types.LOAD_EVENTS_REQUEST
    };
}

export function loadEventsSuccess(events) {
    return {
        type: types.LOAD_EVENTS_SUCCESS,
        events
    };
}

export function loadEventsFailure(error) {
    return {
        type: types.LOAD_EVENTS_FAILURE,
        error
    };
}