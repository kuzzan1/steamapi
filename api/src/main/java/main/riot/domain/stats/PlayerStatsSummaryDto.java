package main.riot.domain.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-18.
 */
public class PlayerStatsSummaryDto {

    @JsonProperty
    private AggregatedStatsDto aggregatedStatsDto;
    @JsonProperty
    private int losses;
    @JsonProperty
    private long modifyDate;
    @JsonProperty
    private String playerStatSummaryType;
    @JsonProperty
    private int wins;

    public AggregatedStatsDto getAggregatedStatsDto() {
        return aggregatedStatsDto;
    }

    public void setAggregatedStatsDto( AggregatedStatsDto aggregatedStatsDto ) {
        this.aggregatedStatsDto = aggregatedStatsDto;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses( int losses ) {
        this.losses = losses;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate( long modifyDate ) {
        this.modifyDate = modifyDate;
    }

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType( String playerStatSummaryType ) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    public int getWins() {
        return wins;
    }

    public void setWins( int wins ) {
        this.wins = wins;
    }
}
