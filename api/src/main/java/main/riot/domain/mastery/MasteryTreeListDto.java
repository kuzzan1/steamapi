package main.riot.domain.mastery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-17.
 */
public class MasteryTreeListDto {

    @JsonProperty
    private List<MasteryTreeItemDto> masteryTreeItems = new ArrayList<>();

    public List<MasteryTreeItemDto> getMasteryTreeItems() {
        return masteryTreeItems;
    }

    public void setMasteryTreeItems( List<MasteryTreeItemDto> masteryTreeItems ) {
        this.masteryTreeItems = masteryTreeItems;
    }
}
