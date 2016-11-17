package main.riot.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.BasicDataDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
public class ItemListDto {
    @JsonProperty
    private BasicDataDto basic;
    @JsonProperty
    private Map data = new HashMap<String, ItemDto>();
    @JsonProperty
    private List groups = new ArrayList<GroupDto>();
    @JsonProperty
    private List tree = new ArrayList<ItemTreeDto>();
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

    public Map getData() {
        return data;
    }

    public void setData( Map data ) {
        this.data = data;
    }

    public List getGroups() {
        return groups;
    }

    public void setGroups( List groups ) {
        this.groups = groups;
    }

    public List getTree() {
        return tree;
    }

    public void setTree( List tree ) {
        this.tree = tree;
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
