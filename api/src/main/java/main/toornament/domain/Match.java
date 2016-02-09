package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2016-02-03.
 */
public class Match {
    @JsonProperty
    private String id;
    @JsonProperty
    private String type;
    @JsonProperty
    private String discipline;
    @JsonProperty
    private String status;
    @JsonProperty(value = "tournament_id")
    private String tournamentId;
    @JsonProperty(value = "stage_number")
    private String stageNumber;
    @JsonProperty(value = "group_number")
    private String groupNumber;
    @JsonProperty(value = "round_number")
    private String roundNumber;
    @JsonProperty
    private String date;
    @JsonProperty(value = "time_zone")
    private String timeZone;
    @JsonProperty(value = "match_format")
    private String matchFormat;
    @JsonProperty
    private List<Opponent> opponents;

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline( String discipline ) {
        this.discipline = discipline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId( String tournamentId ) {
        this.tournamentId = tournamentId;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber( String stageNumber ) {
        this.stageNumber = stageNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber( String groupNumber ) {
        this.groupNumber = groupNumber;
    }

    public String getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber( String roundNumber ) {
        this.roundNumber = roundNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone( String timeZone ) {
        this.timeZone = timeZone;
    }

    public String getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat( String matchFormat ) {
        this.matchFormat = matchFormat;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents( List<Opponent> opponents ) {
        this.opponents = opponents;
    }

}
