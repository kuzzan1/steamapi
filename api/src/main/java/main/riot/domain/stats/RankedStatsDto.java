package main.riot.domain.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-17.
 */
public class RankedStatsDto {

    @JsonProperty
    private List<ChampionStatsDto> champions = new ArrayList<>();
    @JsonProperty
    private long modifyDate;
    @JsonProperty
    private long summonerId;

    public List<ChampionStatsDto> getChampions() {
        return champions;
    }

    public void setChampions( List<ChampionStatsDto> champions ) {
        this.champions = champions;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate( long modifyDate ) {
        this.modifyDate = modifyDate;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId( long summonerId ) {
        this.summonerId = summonerId;
    }
}
