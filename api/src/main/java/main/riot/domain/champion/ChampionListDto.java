package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
public class ChampionListDto {

    @JsonProperty
    private Map data = new HashMap<String, ChampionDto>( );
    @JsonProperty
    private String format;
    @JsonProperty
    private Map keys = new HashMap<String, String>();
    @JsonProperty
    private String type;
    @JsonProperty
    private String version;

    public Map getData() {
        return data;
    }

    public void setData( Map data ) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat( String format ) {
        this.format = format;
    }

    public Map getKeys() {
        return keys;
    }

    public void setKeys( Map keys ) {
        this.keys = keys;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }
}
