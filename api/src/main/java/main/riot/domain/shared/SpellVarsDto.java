package main.riot.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class SpellVarsDto {

    @JsonProperty
    private List<Double> coeff = new ArrayList<>();
    @JsonProperty
    private String dyn;
    @JsonProperty
    private String key;
    @JsonProperty
    private String link;
    @JsonProperty
    private String ranksWith;

    public List<Double> getCoeff() {
        return coeff;
    }

    public void setCoeff( List<Double> coeff ) {
        this.coeff = coeff;
    }

    public String getDyn() {
        return dyn;
    }

    public void setDyn( String dyn ) {
        this.dyn = dyn;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getLink() {
        return link;
    }

    public void setLink( String link ) {
        this.link = link;
    }

    public String getRanksWith() {
        return ranksWith;
    }

    public void setRanksWith( String ranksWith ) {
        this.ranksWith = ranksWith;
    }
}
