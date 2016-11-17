package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class BlockItemDto {

    @JsonProperty
    private int count;
    @JsonProperty
    private int id;

    public int getCount() {
        return count;
    }

    public void setCount( int count ) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
