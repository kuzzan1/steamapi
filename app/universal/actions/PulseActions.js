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

export function editEvent(event) {
    return dispatch => {
        dispatch(editEventRequest(event));

        return request
            .post(eventsUrl + '/' + event.id)
            .send(event)
            .set('Accept', 'application/json')
            .end((err, res) => {
                if (err) {
                    dispatch(editEventFailure(err, event));
                } else {
                    dispatch(editEventSuccess(res.body));
                }
            });
    };
}

export function editEventRequest(event) {
    return {
        type: types.EDIT_EVENT_REQUEST,
        event
    };
}

export function editEventSuccess(event) {
    return {
        type: types.EDIT_EVENT_SUCCESS,
        event
    };
}

export function editEventFailure(error, event) {
    return {
        type: types.EDIT_EVENT_FAILURE,
        error,
        event
    };
}