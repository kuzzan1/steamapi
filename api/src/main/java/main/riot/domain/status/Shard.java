package main.riot.domain.status;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class Shard {

    @JsonProperty
    private String hostName;
    @JsonProperty
    private List<String> locales = new ArrayList<>();
    @JsonProperty
    private String name;
    @JsonProperty
    private String region_tag;
    @JsonProperty
    private String slug;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public List<String> getLocales() {
        return locales;
    }

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion_tag() {
        return region_tag;
    }

    public void setRegion_tag(String region_tag) {
        this.region_tag = region_tag;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
