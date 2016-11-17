package main.riot.domain.mastery;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-17.
 */
public class MasteryTreeItemDto {

    @JsonProperty
    private int masteryId;
    @JsonProperty
    private String prereq;

    public int getMasteryId() {
        return masteryId;
    }

    public void setMasteryId( int masteryId ) {
        this.masteryId = masteryId;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq( String prereq ) {
        this.prereq = prereq;
    }
}
