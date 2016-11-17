package main.riot.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class LevelTipDto {

    @JsonProperty
    private List<String> effect = new ArrayList<>();
    @JsonProperty
    private List<String> label = new ArrayList<>();

    public List<String> getEffect() {
        return effect;
    }

    public void setEffect( List<String> effect ) {
        this.effect = effect;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel( List<String> label ) {
        this.label = label;
    }
}
