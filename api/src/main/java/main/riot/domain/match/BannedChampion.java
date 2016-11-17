package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class BannedChampion {

    @JsonProperty
    private int championId;
    @JsonProperty
    private int pickTurn;

    public int getChampionId() {
        return championId;
    }

    public void setChampionId( int championId ) {
        this.championId = championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn( int pickTurn ) {
        this.pickTurn = pickTurn;
    }
}
