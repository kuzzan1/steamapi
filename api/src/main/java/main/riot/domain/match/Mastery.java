package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class Mastery {
    @JsonProperty
    private long masteryId;
    @JsonProperty
    private long rank;

    public long getMasteryId() {
        return masteryId;
    }

    public void setMasteryId( long masteryId ) {
        this.masteryId = masteryId;
    }

    public long getRank() {
        return rank;
    }

    public void setRank( long rank ) {
        this.rank = rank;
    }
}
