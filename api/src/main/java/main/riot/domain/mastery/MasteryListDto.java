package main.riot.domain.mastery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
public class MasteryListDto {

    private Map data = new HashMap<String, MasteryDto>();
    private MasteryTreeDto tree;
    private String type;
    private String version;

    public Map getData() {
        return data;
    }

    public void setData( Map data ) {
        this.data = data;
    }

    public MasteryTreeDto getTree() {
        return tree;
    }

    public void setTree( MasteryTreeDto tree ) {
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
