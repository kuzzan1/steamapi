package main.riot.domain.map;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.ImageDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-17.
 */
public class MapDetailsDto {

    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private long mapId;
    @JsonProperty
    private String mapName;
    @JsonProperty
    private List unpurchasableItemList = new ArrayList<Long>();

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId( long mapId ) {
        this.mapId = mapId;
    }

    public List getUnpurchasableItemList() {
        return unpurchasableItemList;
    }

    public void setUnpurchasableItemList( List unpurchasableItemList ) {
        this.unpurchasableItemList = unpurchasableItemList;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName( String mapName ) {
        this.mapName = mapName;
    }
}
