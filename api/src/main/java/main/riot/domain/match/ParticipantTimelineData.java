package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class ParticipantTimelineData {
    @JsonProperty
    private double tenToTwenty;
    @JsonProperty
    private double thirtyToEnd;
    @JsonProperty
    private double twentyToThirty;
    @JsonProperty
    private double zeroToTen;

    public double getTenToTwenty() {
        return tenToTwenty;
    }

    public void setTenToTwenty( double tenToTwenty ) {
        this.tenToTwenty = tenToTwenty;
    }

    public double getThirtyToEnd() {
        return thirtyToEnd;
    }

    public void setThirtyToEnd( double thirtyToEnd ) {
        this.thirtyToEnd = thirtyToEnd;
    }

    public double getTwentyToThirty() {
        return twentyToThirty;
    }

    public void setTwentyToThirty( double twentyToThirty ) {
        this.twentyToThirty = twentyToThirty;
    }

    public double getZeroToTen() {
        return zeroToTen;
    }

    public void setZeroToTen( double zeroToTen ) {
        this.zeroToTen = zeroToTen;
    }
}
