package main.riot.domain.currentgame;

import com.fasterxml.jackson.annotation.JsonProperty;

import main.riot.domain.match.IParticipant;
import main.riot.domain.match.Mastery;
import main.riot.domain.match.Rune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class CurrentGameParticipant implements IParticipant {

    @JsonProperty
    private boolean bot;
    @JsonProperty
    private long championId;
    @JsonProperty
    private List<Mastery> masteries = new ArrayList<>();
    @JsonProperty
    private long profileIconId;
    @JsonProperty
    private List<Rune> runes = new ArrayList<>();
    @JsonProperty
    private long spell1Id;
    @JsonProperty
    private long spell2Id;
    @JsonProperty
    private long summonerId;
    @JsonProperty
    private String summonerName;
    @JsonProperty
    private long teamId;

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public void setRunes(List<Rune> runes) {
        this.runes = runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
