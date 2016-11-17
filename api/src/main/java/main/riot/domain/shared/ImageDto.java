package main.riot.domain.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class ImageDto {

    @JsonProperty
    private String full;
    @JsonProperty
    private String group;
    @JsonProperty
    private int h;
    @JsonProperty
    private String sprite;
    @JsonProperty
    private int w;
    @JsonProperty
    private int x;
    @JsonProperty
    private int y;

    public String getFull() {
        return full;
    }

    public void setFull( String full ) {
        this.full = full;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup( String group ) {
        this.group = group;
    }

    public int getH() {
        return h;
    }

    public void setH( int h ) {
        this.h = h;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite( String sprite ) {
        this.sprite = sprite;
    }

    public int getW() {
        return w;
    }

    public void setW( int w ) {
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }
}
