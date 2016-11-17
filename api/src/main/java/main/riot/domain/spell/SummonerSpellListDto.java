package main.riot.domain.spell;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
public class SummonerSpellListDto {

    @JsonProperty
    private Map<String, SummonerSpellDto> data = new HashMap<>();
    @JsonProperty
    private String type;
    @JsonProperty
    private String version;

    public Map<String, SummonerSpellDto> getData() {
        return data;
    }

    public void setData( Map<String, SummonerSpellDto> data ) {
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
