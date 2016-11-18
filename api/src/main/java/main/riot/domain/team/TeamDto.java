package main.riot.domain.team;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-18.
 */
public class TeamDto {

    @JsonProperty
    private long createDate;
    @JsonProperty
    private String fullId;
    @JsonProperty
    private long lastGameDate;
    @JsonProperty
    private long lasJoinDate;
    @JsonProperty
    private long lastJoinedRankedTeamQueueDate;
    @JsonProperty
    private List<MatchHistorySummaryDto> matchHistory = new ArrayList<>();
    @JsonProperty
    private long modifyDate;
    @JsonProperty
    private String name;
    @JsonProperty
    private RosterDto roster;
    @JsonProperty
    private long secondLastJoinDate;
    @JsonProperty
    private String status;
    @JsonProperty
    private String tag;
    @JsonProperty
    private List<TeamStatDetailDto> teamStatdetails = new ArrayList<>();
    @JsonProperty
    private long thirdLastJoinDate;

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public long getLastGameDate() {
        return lastGameDate;
    }

    public void setLastGameDate(long lastGameDate) {
        this.lastGameDate = lastGameDate;
    }

    public long getLasJoinDate() {
        return lasJoinDate;
    }

    public void setLasJoinDate(long lasJoinDate) {
        this.lasJoinDate = lasJoinDate;
    }

    public long getLastJoinedRankedTeamQueueDate() {
        return lastJoinedRankedTeamQueueDate;
    }

    public void setLastJoinedRankedTeamQueueDate(long lastJoinedRankedTeamQueueDate) {
        this.lastJoinedRankedTeamQueueDate = lastJoinedRankedTeamQueueDate;
    }

    public List<MatchHistorySummaryDto> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(List<MatchHistorySummaryDto> matchHistory) {
        this.matchHistory = matchHistory;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RosterDto getRoster() {
        return roster;
    }

    public void setRoster(RosterDto roster) {
        this.roster = roster;
    }

    public long getSecondLastJoinDate() {
        return secondLastJoinDate;
    }

    public void setSecondLastJoinDate(long secondLastJoinDate) {
        this.secondLastJoinDate = secondLastJoinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<TeamStatDetailDto> getTeamStatdetails() {
        return teamStatdetails;
    }

    public void setTeamStatdetails(List<TeamStatDetailDto> teamStatdetails) {
        this.teamStatdetails = teamStatdetails;
    }

    public long getThirdLastJoinDate() {
        return thirdLastJoinDate;
    }

    public void setThirdLastJoinDate(long thirdLastJoinDate) {
        this.thirdLastJoinDate = thirdLastJoinDate;
    }
}
