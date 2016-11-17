package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class ParticipantIdentity {
    @JsonProperty
    private int participantId;
    @JsonProperty
    private Player player;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId( int participantId ) {
        this.participantId = participantId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer( Player player ) {
        this.player = player;
    }
}
