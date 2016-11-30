package main.riot.domain.game;

import main.riot.domain.Timestamp;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jonas on 2016-11-19.
 */
public class RecentGamesDto extends Timestamp {

    @Id
    private long summonerId;
    Set<GameDto> games= new HashSet<>();

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
