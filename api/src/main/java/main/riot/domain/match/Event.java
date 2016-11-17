package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class Event {

    @JsonProperty
    private String ascendedType;
    @JsonProperty
    private List<Integer> assistingParticipantIds = new ArrayList<Integer>();
    @JsonProperty
    private String buildingType;
    @JsonProperty
    private int creatorId;
    @JsonProperty
    private String eventType;
    @JsonProperty
    private int itemAfter;
    @JsonProperty
    private int itemBefore;
    @JsonProperty
    private int itemId;
    @JsonProperty
    private int killerId;
    @JsonProperty
    private String laneType;
    @JsonProperty
    private String levelUpType;
    @JsonProperty
    private String monsterSubType;
    @JsonProperty
    private String monsterType;
    @JsonProperty
    private String pointCaptured;
    @JsonProperty
    private int participantId;
    @JsonProperty
    private Position position;
    @JsonProperty
    private int skillSlot;
    @JsonProperty
    private int teamId;
    @JsonProperty
    private long timeStamp;
    @JsonProperty
    private String towerType;
    @JsonProperty
    private int victimId;
    @JsonProperty
    private String wardType;

    public String getAscendedType() {
        return ascendedType;
    }

    public void setAscendedType( String ascendedType ) {
        this.ascendedType = ascendedType;
    }

    public List<Integer> getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public void setAssistingParticipantIds( List<Integer> assistingParticipantIds ) {
        this.assistingParticipantIds = assistingParticipantIds;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType( String buildingType ) {
        this.buildingType = buildingType;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId( int creatorId ) {
        this.creatorId = creatorId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType( String eventType ) {
        this.eventType = eventType;
    }

    public int getItemAfter() {
        return itemAfter;
    }

    public void setItemAfter( int itemAfter ) {
        this.itemAfter = itemAfter;
    }

    public int getItemBefore() {
        return itemBefore;
    }

    public void setItemBefore( int itemBefore ) {
        this.itemBefore = itemBefore;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId( int itemId ) {
        this.itemId = itemId;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId( int killerId ) {
        this.killerId = killerId;
    }

    public String getLaneType() {
        return laneType;
    }

    public void setLaneType( String laneType ) {
        this.laneType = laneType;
    }

    public String getLevelUpType() {
        return levelUpType;
    }

    public void setLevelUpType( String levelUpType ) {
        this.levelUpType = levelUpType;
    }

    public String getMonsterSubType() {
        return monsterSubType;
    }

    public void setMonsterSubType( String monsterSubType ) {
        this.monsterSubType = monsterSubType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType( String monsterType ) {
        this.monsterType = monsterType;
    }

    public String getPointCaptured() {
        return pointCaptured;
    }

    public void setPointCaptured( String pointCaptured ) {
        this.pointCaptured = pointCaptured;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId( int participantId ) {
        this.participantId = participantId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition( Position position ) {
        this.position = position;
    }

    public int getSkillSlot() {
        return skillSlot;
    }

    public void setSkillSlot( int skillSlot ) {
        this.skillSlot = skillSlot;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId( int teamId ) {
        this.teamId = teamId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp( long timeStamp ) {
        this.timeStamp = timeStamp;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType( String towerType ) {
        this.towerType = towerType;
    }

    public int getVictimId() {
        return victimId;
    }

    public void setVictimId( int victimId ) {
        this.victimId = victimId;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType( String wardType ) {
        this.wardType = wardType;
    }
}
