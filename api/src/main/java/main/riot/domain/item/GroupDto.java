package main.riot.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class GroupDto {
    @JsonProperty
    private String MaxGroupOwnable;
    @JsonProperty
    private String key;

    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    public void setMaxGroupOwnable( String maxGroupOwnable ) {
        MaxGroupOwnable = maxGroupOwnable;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }
}
