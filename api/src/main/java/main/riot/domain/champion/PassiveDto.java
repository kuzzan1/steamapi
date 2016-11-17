package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.ImageDto;

/**
 * Created by jonas on 2016-11-16.
 */
public class PassiveDto {

    @JsonProperty
    private String description;
    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private String name;
    @JsonProperty
    private String sanitizedDescription;

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription( String sanitizedDescription ) {
        this.sanitizedDescription = sanitizedDescription;
    }
}
