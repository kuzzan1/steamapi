package main.riot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by jonas on 2016-11-30.
 */
public class Timestamp implements Serializable {
    @JsonIgnore
    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp( long timestamp ) {
        this.timestamp = timestamp;
    }
}
