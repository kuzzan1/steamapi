package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class MatchList implements Serializable {

    @JsonProperty
    private int endIndex;
    @JsonProperty
    private List<MatchReference> matches = new ArrayList<>();
    @JsonProperty
    private int startIndex;
    @JsonProperty
    private int totalGames;

    private long summonerId;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public List<MatchReference> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchReference> matches) {
        this.matches = matches;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }
}
