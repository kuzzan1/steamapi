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
    private Set<GameDto> games= new HashSet<>();
    private String locale;

    public Set<GameDto> getGames() {
        return games;
    }

    public void setGames(Set<GameDto> games) {
        this.games = games;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
