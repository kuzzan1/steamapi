package main.riot.domain.featured;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-18.
 */
public class FeaturedGames {

    @JsonProperty
    private long clientRefreshInterval;
    @JsonProperty
    private List<FeaturedGameInfo> gameList = new ArrayList<>();

    public long getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    public void setClientRefreshInterval( long clientRefreshInterval ) {
        this.clientRefreshInterval = clientRefreshInterval;
    }

    public List<FeaturedGameInfo> getGameList() {
        return gameList;
    }

    public void setGameList( List<FeaturedGameInfo> gameList ) {
        this.gameList = gameList;
    }
}
