package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class Champions {
    @JsonProperty(value = "data")
    private List<Champion> champions = new ArrayList<>(  );

    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions( List<Champion> champions ) {
        this.champions = champions;
    }
}
