package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class RecommendedDto {

    @JsonProperty
    private List<BlockDto> blocks = new ArrayList<>();
    @JsonProperty
    private String champion;
    @JsonProperty
    private String map;
    @JsonProperty
    private String mode;
    @JsonProperty
    private boolean priority;
    @JsonProperty
    private String title;
    @JsonProperty
    private String type;

    public List<BlockDto> getBlocks() {
        return blocks;
    }

    public void setBlocks( List<BlockDto> blocks ) {
        this.blocks = blocks;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion( String champion ) {
        this.champion = champion;
    }

    public String getMap() {
        return map;
    }

    public void setMap( String map ) {
        this.map = map;
    }

    public String getMode() {
        return mode;
    }

    public void setMode( String mode ) {
        this.mode = mode;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority( boolean priority ) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }
}
