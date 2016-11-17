package main.riot.domain.rune;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.BasicDataDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
public class RuneListDto {

    @JsonProperty
    private BasicDataDto basic;
    @JsonProperty
    private Map<String, RuneDto> data = new HashMap<>();
    @JsonProperty
    private String type;
    @JsonProperty
    private String version;

    public BasicDataDto getBasic() {
        return basic;
    }

    public void setBasic( BasicDataDto basic ) {
        this.basic = basic;
    }

    public Map<String, RuneDto> getData() {
        return data;
    }

    public void setData( Map<String, RuneDto> data ) {
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
