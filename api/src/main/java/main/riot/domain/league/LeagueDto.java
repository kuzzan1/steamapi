package main.riot.domain.league;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class LeagueDto {

    @JsonProperty
    private List<LeagueEntryDto> entries = new ArrayList<>();
    @JsonProperty
    private String name;
    @JsonProperty
    private String participantId;
    @JsonProperty
    private String queue;
    @JsonProperty
    private String tier;

    public List<LeagueEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<LeagueEntryDto> entries) {
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
