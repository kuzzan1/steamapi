package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class TimeLine {
    @JsonProperty
    private long frameInterval;
    @JsonProperty
    private List<Frame> frames = new ArrayList<>();

    public long getFrameInterval() {
        return frameInterval;
    }

    public void setFrameInterval( long frameInterval ) {
        this.frameInterval = frameInterval;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames( List<Frame> frames ) {
        this.frames = frames;
    }
}
