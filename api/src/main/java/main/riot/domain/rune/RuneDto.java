package main.riot.domain.rune;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.MetaDataDto;
import main.riot.domain.shared.BasicDataStatsDto;
import main.riot.domain.shared.ImageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
public class RuneDto {

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
    private List<String> from = new ArrayList<>();
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
    private List<String> into = new ArrayList<>();
    @JsonProperty
    private Map<String, Boolean> maps = new HashMap<>();
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
    private List<String> tags = new ArrayList<>();

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

    public List<String> getFrom() {
        return from;
    }

    public void setFrom( List<String> from ) {
        this.from = from;
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

    public List<String> getInto() {
        return into;
    }

    public void setInto( List<String> into ) {
        this.into = into;
    }

    public Map<String, Boolean> getMaps() {
        return maps;
    }

    public void setMaps( Map<String, Boolean> maps ) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags( List<String> tags ) {
        this.tags = tags;
    }
}
