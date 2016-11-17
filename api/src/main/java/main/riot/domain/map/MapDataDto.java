package main.riot.domain.map;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
public class MapDataDto {

    @JsonProperty
    private Map data = new HashMap<String, MapDetailsDto>();
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
