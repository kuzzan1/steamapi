package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class Champion {
    @JsonProperty
    private int id;
    @JsonProperty
    private boolean active;
    @JsonProperty
    private boolean botEnabled;
    @JsonProperty
    private boolean freeToPlay;
    @JsonProperty
    private boolean botMmEnabled;
    @JsonProperty
    private boolean rankedPlayEnabled;
    @JsonProperty
    private ChampionListDto championListDto;
    @JsonProperty
    private String key;
    @JsonProperty
    private String title;
    @JsonProperty
    private String name;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive( boolean active ) {
        this.active = active;
    }

    public boolean isBotEnabled() {
        return botEnabled;
    }

    public void setBotEnabled( boolean botEnabled ) {
        this.botEnabled = botEnabled;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public void setFreeToPlay( boolean freeToPlay ) {
        this.freeToPlay = freeToPlay;
    }

    public boolean isBotMmEnabled() {
        return botMmEnabled;
    }

    public void setBotMmEnabled( boolean botMmEnabled ) {
        this.botMmEnabled = botMmEnabled;
    }

    public boolean isRankedPlayEnabled() {
        return rankedPlayEnabled;
    }

    public void setRankedPlayEnabled( boolean rankedPlayEnabled ) {
        this.rankedPlayEnabled = rankedPlayEnabled;
    }

    public ChampionListDto getChampionListDto() {
        return championListDto;
    }

    public void setChampionListDto( ChampionListDto championListDto ) {
        this.championListDto = championListDto;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
