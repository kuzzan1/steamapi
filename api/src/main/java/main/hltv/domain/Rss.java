package main.hltv.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jonas on 2016-01-18.
 */
@XmlRootElement(name = "rss")
public class Rss {
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @XmlElement
    public void setChannel( Channel channel ) {
        this.channel = channel;
    }
}
