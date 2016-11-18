package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class Participant {
    @JsonProperty
    private int championId;
    @JsonProperty
    private String highestAchievedSeasonTier;
    @JsonProperty
    private List<Mastery> masteries;
    @JsonProperty
    private int participantId;
    @JsonProperty
    private List<Rune> runes;
    @JsonProperty
    private int spell1Id;
    @JsonProperty
    private int spell2Id;
    @JsonProperty
    private ParticipantStats stats;
    @JsonProperty
    private int teamId;
    @JsonProperty
    private ParticipantTimeline timeline;
    @JsonProperty
    private String summonerName;
    @JsonProperty
    private boolean bot;
    @JsonProperty
    private long profileIconId;


    public int getChampionId() {
        return championId;
    }

    public void setChampionId( int championId ) {
        this.championId = championId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void setHighestAchievedSeasonTier( String highestAchievedSeasonTier ) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries( List<Mastery> masteries ) {
        this.masteries = masteries;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId( int participantId ) {
        this.participantId = participantId;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public void setRunes( List<Rune> runes ) {
        this.runes = runes;
    }

    public int getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id( int spell1Id ) {
        this.spell1Id = spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id( int spell2Id ) {
        this.spell2Id = spell2Id;
    }

    public ParticipantStats getStats() {
        return stats;
    }

    public void setStats( ParticipantStats stats ) {
        this.stats = stats;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId( int teamId ) {
        this.teamId = teamId;
    }

    public ParticipantTimeline getTimeline() {
        return timeline;
    }

    public void setTimeline( ParticipantTimeline timeline ) {
        this.timeline = timeline;
    }
}
