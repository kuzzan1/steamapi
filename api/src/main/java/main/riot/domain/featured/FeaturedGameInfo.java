package main.riot.domain.featured;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.match.BannedChampion;
import main.riot.domain.match.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-18.
 */
public class FeaturedGameInfo {

    @JsonProperty
    private List<BannedChampion> bannedChampions = new ArrayList<>();
    @JsonProperty
    private long gameId;
    @JsonProperty
    private long gameLength;
    @JsonProperty
    private String gameMode;
    @JsonProperty
    private long gameQueueConfigId;
    @JsonProperty
    private long gameStartTime;
    @JsonProperty
    private String gameType;
    @JsonProperty
    private long mapId;
    @JsonProperty
    private Observer observers;
    @JsonProperty
    private List<Participant> participants = new ArrayList<>();
    @JsonProperty
    private String platformId;

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions( List<BannedChampion> bannedChampions ) {
        this.bannedChampions = bannedChampions;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId( long gameId ) {
        this.gameId = gameId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength( long gameLength ) {
        this.gameLength = gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode( String gameMode ) {
        this.gameMode = gameMode;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public void setGameQueueConfigId( long gameQueueConfigId ) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime( long gameStartTime ) {
        this.gameStartTime = gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType( String gameType ) {
        this.gameType = gameType;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId( long mapId ) {
        this.mapId = mapId;
    }

    public Observer getObservers() {
        return observers;
    }

    public void setObservers( Observer observers ) {
        this.observers = observers;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants( List<Participant> participants ) {
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId( String platformId ) {
        this.platformId = platformId;
    }
}
