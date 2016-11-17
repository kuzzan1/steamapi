package main.riot.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.BasicDataStatsDto;
import main.riot.domain.shared.ImageDto;
import main.riot.domain.shared.MetaDataDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
public class ItemDto {

    @JsonProperty
    private String colloq;
    @JsonProperty
    private boolean consumeOnFull;
    @JsonProperty
    private boolean consumed;
    @JsonProperty
    private int depth;
    @JsonProperty
    private String description;
    @JsonProperty
    private Map effect = new HashMap<String, String>();
    @JsonProperty
    private List from = new ArrayList<String>();
    @JsonProperty
    private GoldDto gold;
    @JsonProperty
    private String group;
    @JsonProperty
    private boolean hideFromAll;
    @JsonProperty
    private int id;
    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private boolean inStore;
    @JsonProperty
    private List into = new ArrayList<String>();
    @JsonProperty
    private Map maps = new HashMap<String, Boolean>();
    @JsonProperty
    private String name;
    @JsonProperty
    private String plaintext;
    @JsonProperty
    private String requiredChampion;
    @JsonProperty
    private MetaDataDto rune;
    @JsonProperty
    private String sanitizedDescription;
    @JsonProperty
    private int specialRecipe;
    @JsonProperty
    private int stacks;
    @JsonProperty
    private BasicDataStatsDto stats;
    @JsonProperty
    private List tags = new ArrayList<String>();


    public String getColloq() {
        return colloq;
    }

    public void setColloq( String colloq ) {
        this.colloq = colloq;
    }

    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }

    public void setConsumeOnFull( boolean consumeOnFull ) {
        this.consumeOnFull = consumeOnFull;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed( boolean consumed ) {
        this.consumed = consumed;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth( int depth ) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Map getEffect() {
        return effect;
    }

    public void setEffect( Map effect ) {
        this.effect = effect;
    }

    public List getFrom() {
        return from;
    }

    public void setFrom( List from ) {
        this.from = from;
    }

    public GoldDto getGold() {
        return gold;
    }

    public void setGold( GoldDto gold ) {
        this.gold = gold;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup( String group ) {
        this.group = group;
    }

    public boolean isHideFromAll() {
        return hideFromAll;
    }

    public void setHideFromAll( boolean hideFromAll ) {
        this.hideFromAll = hideFromAll;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore( boolean inStore ) {
        this.inStore = inStore;
    }

    public List getInto() {
        return into;
    }

    public void setInto( List into ) {
        this.into = into;
    }

    public Map getMaps() {
        return maps;
    }

    public void setMaps( Map maps ) {
        this.maps = maps;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext( String plaintext ) {
        this.plaintext = plaintext;
    }

    public String getRequiredChampion() {
        return requiredChampion;
    }

    public void setRequiredChampion( String requiredChampion ) {
        this.requiredChampion = requiredChampion;
    }

    public MetaDataDto getRune() {
        return rune;
    }

    public void setRune( MetaDataDto rune ) {
        this.rune = rune;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription( String sanitizedDescription ) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public int getSpecialRecipe() {
        return specialRecipe;
    }

    public void setSpecialRecipe( int specialRecipe ) {
        this.specialRecipe = specialRecipe;
    }

    public int getStacks() {
        return stacks;
    }

    public void setStacks( int stacks ) {
        this.stacks = stacks;
    }

    public BasicDataStatsDto getStats() {
        return stats;
    }

    public void setStats( BasicDataStatsDto stats ) {
        this.stats = stats;
    }

    public List getTags() {
        return tags;
    }

    public void setTags( List tags ) {
        this.tags = tags;
    }
}
