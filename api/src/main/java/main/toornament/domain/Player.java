package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-02-05.
 */
public class Player {

    @JsonProperty
    private String name;
    @JsonProperty
    private String country;
    private String teamName;
    private String teamId;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public void setTeam( Participant team ) {
        this.teamName = team.getName();
        this.teamId = team.getId();
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName( String teamName ) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId( String teamId ) {
        this.teamId = teamId;
    }
}
