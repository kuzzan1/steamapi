package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2016-02-03.
 */
public class Participant {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String country;
    @JsonProperty(value = "lineup")
    private List<Player> players;

    private String discipline;


    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers( List<Player> players ) {
        this.players = players;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline( String discipline ) {
        this.discipline = discipline;
    }
}
