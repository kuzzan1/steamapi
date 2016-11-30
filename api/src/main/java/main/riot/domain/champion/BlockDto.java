package main.riot.domain.champion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class BlockDto {

    private boolean recMatch;
    private String type;
    private List<BlockItemDto> items = new ArrayList<>();

    public List<BlockItemDto> getItems() {
        return items;
    }

    public void setItems( List<BlockItemDto> items ) {
        this.items = items;
    }

    public boolean isRecMatch() {
        return recMatch;
    }

    public void setRecMatch( boolean recMatch ) {
        this.recMatch = recMatch;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }
}
