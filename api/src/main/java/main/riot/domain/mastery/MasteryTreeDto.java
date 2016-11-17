package main.riot.domain.mastery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-17.
 */
public class MasteryTreeDto {

    @JsonProperty
    private List<MasteryTreeListDto> Cunning = new ArrayList<>();
    @JsonProperty
    private List<MasteryTreeListDto> Ferocity = new ArrayList<>();
    @JsonProperty
    private List<MasteryTreeListDto> Resolve = new ArrayList<>();

    public List<MasteryTreeListDto> getCunning() {
        return Cunning;
    }

    public void setCunning( List<MasteryTreeListDto> cunning ) {
        Cunning = cunning;
    }

    public List<MasteryTreeListDto> getFerocity() {
        return Ferocity;
    }

    public void setFerocity( List<MasteryTreeListDto> ferocity ) {
        Ferocity = ferocity;
    }

    public List<MasteryTreeListDto> getResolve() {
        return Resolve;
    }

    public void setResolve( List<MasteryTreeListDto> resolve ) {
        Resolve = resolve;
    }
}
