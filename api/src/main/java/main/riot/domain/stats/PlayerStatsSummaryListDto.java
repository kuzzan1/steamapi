package main.riot.domain.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-18.
 */
public class PlayerStatsSummaryListDto {

    @JsonProperty
    private List<PlayerStatsSummaryDto> playerStatsSummaries = new ArrayList<>();
    @JsonProperty
    private long summonerId;

    public List<PlayerStatsSummaryDto> getPlayerStatsSummaries() {
        return playerStatsSummaries;
    }

    public void setPlayerStatsSummaries( List<PlayerStatsSummaryDto> playerStatsSummaries ) {
        this.playerStatsSummaries = playerStatsSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }
}
