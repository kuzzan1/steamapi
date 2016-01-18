package main.hltv.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by jonas on 2016-01-18.
 */
public class Channel {

    private String title;
    private String link;
    private String description;
    private List<Item> items;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle( String title ) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    @XmlElement
    public void setLink( String link ) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription( String description ) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    @XmlElement(name = "item")
    public void setItems( List<Item> items ) {
        this.items = items;
    }
}
