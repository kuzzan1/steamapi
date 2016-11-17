package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class SkinDto {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int num;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum( int num ) {
        this.num = num;
    }
}
