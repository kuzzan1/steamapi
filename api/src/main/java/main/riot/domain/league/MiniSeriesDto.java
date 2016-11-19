package main.riot.domain.league;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-19.
 */
public class MiniSeriesDto {

    @JsonProperty
    private int losses;
    @JsonProperty
    private String progress;
    @JsonProperty
    private int target;
    @JsonProperty
    private int wins;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
