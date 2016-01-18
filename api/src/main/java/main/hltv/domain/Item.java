package main.hltv.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by jonas on 2016-01-18.
 */
public class Item {

    private String title;
    private String link;
    private String description;
    private String pubDate;

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

    public String getPubDate() {
        return pubDate;
    }

    @XmlElement
    public void setPubDate( String pubDate ) {
        this.pubDate = pubDate;
    }
}
