package main.riot.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-17.
 */
public class MetaDataDto {

    @JsonProperty
    private boolean isRune;
    @JsonProperty
    private String tier;
    @JsonProperty
    private String type;

    public boolean isRune() {
        return isRune;
    }

    public void setRune( boolean rune ) {
        isRune = rune;
    }

    public String getTier() {
        return tier;
    }

    public void setTier( String tier ) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }
}
