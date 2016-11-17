package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class ParticipantFrame {
    @JsonProperty
    private int dominionScore;
    @JsonProperty
    private int jungleMinionsKilled;
    @JsonProperty
    private int level;
    @JsonProperty
    private int minionsKilled;
    @JsonProperty
    private int participantId;
    @JsonProperty
    private int totalGold;
    @JsonProperty
    private int teamScore;
    @JsonProperty
    private int xp;
    @JsonProperty
    private Position position;
}
