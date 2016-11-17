package main.riot.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class ItemTreeDto {

    @JsonProperty
    private String header;
    @JsonProperty
    private List tags = new ArrayList<String>();

    public String getHeader() {
        return header;
    }

    public void setHeader( String header ) {
        this.header = header;
    }

    public List getTags() {
        return tags;
    }

    public void setTags( List tags ) {
        this.tags = tags;
    }
}
