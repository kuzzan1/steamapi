package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2016-02-01.
 */
public class Tournament {

    @JsonProperty(value = "id")
    private String tournamentId;
    @JsonProperty
    private String discipline;
    @JsonProperty
    private String name;
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonProperty
    private String status;
    @JsonProperty(value = "date_start")
    private String dateStart;
    @JsonProperty(value = "date_end")
    private String dateEnd;
    @JsonProperty
    private boolean online;
    @JsonProperty(value = "public")
    private boolean isPublic;
    @JsonProperty
    private String location;
    @JsonProperty
    private String country;
    @JsonProperty
    private Long size;
    @JsonProperty
    private List maps;
    @JsonProperty
    private String timeZone;
    @JsonProperty(value = "participant_type")
    private String participantType;
    @JsonProperty(value = "match_type")
    private String matchType;
    private String organization;
    private String website;
    private String description;
    private String rules;
    private String prize;
    @JsonProperty(value = "team_size_min")
    private Long teamSizeMin;
    @JsonProperty(value = "team_size_max")
    private Long teamSizeMax;
    @JsonProperty
    private List streams;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId( String tournamentId ) {
        this.tournamentId = tournamentId;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline( String discipline ) {
        this.discipline = discipline;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName( String fullName ) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline( boolean online ) {
        this.online = online;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic( boolean isPublic ) {
        this.isPublic = isPublic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public Long getSize() {
        return size;
    }

    public void setSize( Long size ) {
        this.size = size;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart( String dateStart ) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd( String dateEnd ) {
        this.dateEnd = dateEnd;
    }

    public List getMaps() {
        return maps;
    }

    public void setMaps( List maps ) {
        this.maps = maps;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone( String timeZone ) {
        this.timeZone = timeZone;
    }

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType( String participantType ) {
        this.participantType = participantType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType( String matchType ) {
        this.matchType = matchType;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization( String organization ) {
        this.organization = organization;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite( String website ) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules( String rules ) {
        this.rules = rules;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize( String prize ) {
        this.prize = prize;
    }

    public Long getTeamSizeMin() {
        return teamSizeMin;
    }

    public void setTeamSizeMin( Long teamSizeMin ) {
        this.teamSizeMin = teamSizeMin;
    }

    public Long getTeamSizeMax() {
        return teamSizeMax;
    }

    public void setTeamSizeMax( Long teamSizeMax ) {
        this.teamSizeMax = teamSizeMax;
    }

    public List getStreams() {
        return streams;
    }

    public void setStreams( List streams ) {
        this.streams = streams;
    }

}
