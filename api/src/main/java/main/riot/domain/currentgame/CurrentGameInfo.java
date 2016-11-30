package main.riot.domain.currentgame;

import main.riot.domain.Timestamp;
import main.riot.domain.match.IMatchInfo;
import main.riot.domain.match.IParticipant;
import main.riot.domain.shared.BannedChampion;
import main.riot.domain.shared.Observer;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class CurrentGameInfo extends Timestamp implements IMatchInfo {

    @Id
    private long gameId;
    private long gameLength;
    private String gameMode;
    private long gameQueueConfigId;
    private long gameStartTime;
    private String gameType;
    private long mapId;
    private Observer observers;
    private String platformId;
    private List<BannedChampion> bannedChampions = new ArrayList<>();
    private List<CurrentGameParticipant> participants = new ArrayList<>();
    private long summonerId;

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(List<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength(long gameLength) {
        this.gameLength = gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public void setGameQueueConfigId(long gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public Observer getObservers() {
        return observers;
    }

    public void setObservers(Observer observers) {
        this.observers = observers;
    }

    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CurrentGameParticipant> participants) {
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

	@Override
	public long getId() {
		return gameId;
	}

	@Override
	public List<? extends IParticipant> getMatchParticipants() {
		return participants;
	}

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }

    public long getSummonerId() {
        return summonerId;
    }
}
