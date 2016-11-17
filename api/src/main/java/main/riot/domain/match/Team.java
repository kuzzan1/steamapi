package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class Team {
    @JsonProperty
    private List<BannedChampion> bans = new ArrayList<>();
    @JsonProperty
    private int baronKills;
    @JsonProperty
    private long dominionVictoryScore;
    @JsonProperty
    private int dragonKills;
    @JsonProperty
    private boolean firstBaron;
    @JsonProperty
    private boolean firstBlood;
    @JsonProperty
    private boolean firstDragon;
    @JsonProperty
    private boolean firstInhibitor;
    @JsonProperty
    private boolean firstRiftHerald;
    @JsonProperty
    private boolean firstTower;
    @JsonProperty
    private int inihibitorKills;
    @JsonProperty
    private int riftHeraldKills;
    @JsonProperty
    private int teamId;
    @JsonProperty
    private int towerKills;
    @JsonProperty
    private int vilemawKills;
    @JsonProperty
    private boolean winner;

    public List<BannedChampion> getBans() {
        return bans;
    }

    public void setBans( List<BannedChampion> bans ) {
        this.bans = bans;
    }

    public int getBaronKills() {
        return baronKills;
    }

    public void setBaronKills( int baronKills ) {
        this.baronKills = baronKills;
    }

    public long getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore( long dominionVictoryScore ) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills( int dragonKills ) {
        this.dragonKills = dragonKills;
    }

    public boolean isFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron( boolean firstBaron ) {
        this.firstBaron = firstBaron;
    }

    public boolean isFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood( boolean firstBlood ) {
        this.firstBlood = firstBlood;
    }

    public boolean isFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon( boolean firstDragon ) {
        this.firstDragon = firstDragon;
    }

    public boolean isFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor( boolean firstInhibitor ) {
        this.firstInhibitor = firstInhibitor;
    }

    public boolean isFirstRiftHerald() {
        return firstRiftHerald;
    }

    public void setFirstRiftHerald( boolean firstRiftHerald ) {
        this.firstRiftHerald = firstRiftHerald;
    }

    public boolean isFirstTower() {
        return firstTower;
    }

    public void setFirstTower( boolean firstTower ) {
        this.firstTower = firstTower;
    }

    public int getInihibitorKills() {
        return inihibitorKills;
    }

    public void setInihibitorKills( int inihibitorKills ) {
        this.inihibitorKills = inihibitorKills;
    }

    public int getRiftHeraldKills() {
        return riftHeraldKills;
    }

    public void setRiftHeraldKills( int riftHeraldKills ) {
        this.riftHeraldKills = riftHeraldKills;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId( int teamId ) {
        this.teamId = teamId;
    }

    public int getTowerKills() {
        return towerKills;
    }

    public void setTowerKills( int towerKills ) {
        this.towerKills = towerKills;
    }

    public int getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills( int vilemawKills ) {
        this.vilemawKills = vilemawKills;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner( boolean winner ) {
        this.winner = winner;
    }
}
