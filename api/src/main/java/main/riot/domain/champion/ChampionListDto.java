package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
public class ChampionListDto implements Serializable {

    @JsonProperty
    private List<ChampionDto> champions = new ArrayList<>();
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

    @Id
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

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

    public List<ChampionDto> getChampions() {
        return champions;
    }

    public void setChampions(List<ChampionDto> champions) {
        this.champions = champions;
    }
}
