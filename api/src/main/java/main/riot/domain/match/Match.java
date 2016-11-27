package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class Match implements IMatchInfo {
    @JsonProperty
    private int mapId;
    @JsonProperty
    private long matchCreation;
    @JsonProperty
    private long matchDuration;
    @JsonProperty
    private long matchId;
    @JsonProperty
    private String matchMode;
    @JsonProperty
    private String matchType;
    @JsonProperty
    private String matchVersion;
    @JsonProperty
    private List<ParticipantIdentity> participantIdentities = new ArrayList<>( );
    @JsonProperty
    private List<Participant> participants = new ArrayList<>( );
    @JsonProperty
    private String platformId;
    @JsonProperty
    private String queueType;
    @JsonProperty
    private String region;
    @JsonProperty
    private String season;

    private List<Team> teams = new ArrayList<>(  );
    private TimeLine timeLine;

    public int getMapId() {
        return mapId;
    }

    public void setMapId( int mapId ) {
        this.mapId = mapId;
    }

    public long getMatchCreation() {
        return matchCreation;
    }

    public void setMatchCreation( long matchCreation ) {
        this.matchCreation = matchCreation;
    }

    public long getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration( long matchDuration ) {
        this.matchDuration = matchDuration;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId( long matchId ) {
        this.matchId = matchId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode( String matchMode ) {
        this.matchMode = matchMode;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType( String matchType ) {
        this.matchType = matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public void setMatchVersion( String matchVersion ) {
        this.matchVersion = matchVersion;
    }

    public List<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities( List<ParticipantIdentity> participantIdentities ) {
    	//Set participaints summonerID:
    	if(participants != null)
    	{
    		for(int i=0; i<participantIdentities.size();i++)
    		{
    			participants.get(i).setSummonerId(participantIdentities.get(i).getPlayer().getSummonerId());
    		}
    	}
        this.participantIdentities = participantIdentities;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants( List<Participant> participants ) {
    	//Set participaints summonerID:
    	if(participantIdentities != null)
    	{
    		for(int i=0; i<participantIdentities.size();i++)
    		{
    			participants.get(i).setSummonerId(participantIdentities.get(i).getPlayer().getSummonerId());
    		}
    	}
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId( String platformId ) {
        this.platformId = platformId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType( String queueType ) {
        this.queueType = queueType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion( String region ) {
        this.region = region;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason( String season ) {
        this.season = season;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams( List<Team> teams ) {
        this.teams = teams;
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    public void setTimeLine( TimeLine timeLine ) {
        this.timeLine = timeLine;
    }

	@Override
	public long getId() {
		return matchId;
	}

	@Override
	public List<? extends IParticipant> getMatchParticipants() {
		return participants;
	}
}
