package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
public class Frame {
    @JsonProperty
    private List<Event> events = new ArrayList<>();
    @JsonProperty
    private Map participantFrames = new HashMap<String, ParticipantFrame>();
    @JsonProperty
    private long timestamp;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents( List<Event> events ) {
        this.events = events;
    }

    public Map getParticipantFrames() {
        return participantFrames;
    }

    public void setParticipantFrames( Map participantFrames ) {
        this.participantFrames = participantFrames;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp( long timestamp ) {
        this.timestamp = timestamp;
    }
}
