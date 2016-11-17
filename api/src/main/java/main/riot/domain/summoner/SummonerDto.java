package main.riot.domain.summoner;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-17.
 */
public class SummonerDto {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int profileIconId;
    @JsonProperty
    private long summonerLevel;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId( int profileIconId ) {
        this.profileIconId = profileIconId;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel( long summonerLevel ) {
        this.summonerLevel = summonerLevel;
    }
}
