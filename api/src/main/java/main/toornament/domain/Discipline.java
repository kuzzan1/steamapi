package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-02-09.
 */
public class Discipline {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty(value = "shortname")
    private String shortName;
    @JsonProperty(value = "fullname")
    private String fullName;
    @JsonProperty
    private String copyrights;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }
}
