package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class Rune {
    @JsonProperty
    private long rank;
    @JsonProperty
    private long runeId;

    public long getRank() {
        return rank;
    }

    public void setRank( long rank ) {
        this.rank = rank;
    }

    public long getRuneId() {
        return runeId;
    }

    public void setRuneId( long runeId ) {
        this.runeId = runeId;
    }
}
