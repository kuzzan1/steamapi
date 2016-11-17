package main.riot.domain.mastery;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.ImageDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-17.
 */
public class MasteryDto {
    @JsonProperty
    private List description = new ArrayList<String>();
    @JsonProperty
    private int id;
    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private String masteryTree;
    @JsonProperty
    private String name;
    @JsonProperty
    private String prereq;
    @JsonProperty
    private int ranks;
    @JsonProperty
    private List sanitizedDescription = new ArrayList<String>();

    public List getDescription() {
        return description;
    }

    public void setDescription( List description ) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public String getMasteryTree() {
        return masteryTree;
    }

    public void setMasteryTree( String masteryTree ) {
        this.masteryTree = masteryTree;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq( String prereq ) {
        this.prereq = prereq;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanks( int ranks ) {
        this.ranks = ranks;
    }

    public List getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription( List sanitizedDescription ) {
        this.sanitizedDescription = sanitizedDescription;
    }
}
