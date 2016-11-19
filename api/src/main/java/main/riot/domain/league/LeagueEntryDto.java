package main.riot.domain.league;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-19.
 */
public class LeagueEntryDto {

    @JsonProperty
    private String division;
    @JsonProperty
    private boolean isFreshBlood;
    @JsonProperty
    private boolean isHotStreak;
    @JsonProperty
    private boolean isInactive;
    @JsonProperty
    private boolean isVeteran;
    @JsonProperty
    private int leaguePoints;
    @JsonProperty
    private int losses;
    @JsonProperty
    private MiniSeriesDto miniSeries;
    @JsonProperty
    private String playerOrTeamID;
    @JsonProperty
    private String playerOrTeamName;
    @JsonProperty
    private String playStyle;
    @JsonProperty
    private int wins;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public boolean isFreshBlood() {
        return isFreshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        isFreshBlood = freshBlood;
    }

    public boolean isHotStreak() {
        return isHotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        isHotStreak = hotStreak;
    }

    public boolean isInactive() {
        return isInactive;
    }

    public void setInactive(boolean inactive) {
        isInactive = inactive;
    }

    public boolean isVeteran() {
        return isVeteran;
    }

    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }

    public String getPlayerOrTeamID() {
        return playerOrTeamID;
    }

    public void setPlayerOrTeamID(String playerOrTeamID) {
        this.playerOrTeamID = playerOrTeamID;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public String getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(String playStyle) {
        this.playStyle = playStyle;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
