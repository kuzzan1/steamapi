package main.riot.domain.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-17.
 */
public class ChampionStatsDto {

    @JsonProperty
    private int id;
    @JsonProperty
    private AggregatedStatsDto stas;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public AggregatedStatsDto getStas() {
        return stas;
    }

    public void setStas( AggregatedStatsDto stas ) {
        this.stas = stas;
    }
}
