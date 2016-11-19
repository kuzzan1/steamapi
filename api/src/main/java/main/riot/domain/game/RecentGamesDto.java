package main.riot.domain.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jonas on 2016-11-19.
 */
public class RecentGamesDto {

    @JsonProperty
    Set<GameDto> games= new HashSet<>();
    @JsonProperty
    private long summonerId;

    public Set<GameDto> getGames() {
        return games;
    }

    public void setGames(Set<GameDto> games) {
        this.games = games;
    }

    public long getSummo() {
        return summonerId;
    }

    public void setSummo(long summonerId) {
        this.summonerId = summonerId;
    }
}
