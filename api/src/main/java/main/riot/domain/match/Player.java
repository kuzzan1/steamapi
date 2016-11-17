package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class Player {
    @JsonProperty
    private String matchHistoryUri;
    @JsonProperty
    private int profileIcon;
    @JsonProperty
    private long summonerId;
    @JsonProperty
    private String summonerName;

    public String getMatchHistoryUri() {
        return matchHistoryUri;
    }

    public void setMatchHistoryUri( String matchHistoryUri ) {
        this.matchHistoryUri = matchHistoryUri;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon( int profileIcon ) {
        this.profileIcon = profileIcon;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName( String summonerName ) {
        this.summonerName = summonerName;
    }
}
