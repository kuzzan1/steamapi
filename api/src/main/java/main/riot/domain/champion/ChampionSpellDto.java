package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.ImageDto;
import main.riot.domain.shared.LevelTipDto;
import main.riot.domain.shared.SpellVarsDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class ChampionSpellDto {

    @JsonProperty
    private List<ImageDto> allimages = new ArrayList<>();
    @JsonProperty
    private List<Double> cooldown = new ArrayList<>();
    @JsonProperty
    private String cooldownBurn;
    @JsonProperty
    private List<Integer> cost = new ArrayList<>();
    @JsonProperty
    private String costBurn;
    @JsonProperty
    private String costType;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<Object> effect = new ArrayList<>();
    @JsonProperty
    private List<String> effectBurn = new ArrayList<>();
    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private String key;
    @JsonProperty
    private LevelTipDto leveltip;
    @JsonProperty
    private int maxrank;
    @JsonProperty
    private String name;
    @JsonProperty
    private Object range;
    @JsonProperty
    private String rangeBurn;
    @JsonProperty
    private String resource;
    @JsonProperty
    private String sanitizedDescription;
    @JsonProperty
    private String sanitizedTooltip;
    @JsonProperty
    private String tooltip;
    @JsonProperty
    private List<SpellVarsDto> vars = new ArrayList<>();

    public List<ImageDto> getAllimages() {
        return allimages;
    }

    public void setAllimages( List<ImageDto> allimages ) {
        this.allimages = allimages;
    }

    public List<Double> getCooldown() {
        return cooldown;
    }

    public void setCooldown( List<Double> cooldown ) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn( String cooldownBurn ) {
        this.cooldownBurn = cooldownBurn;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost( List<Integer> cost ) {
        this.cost = cost;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn( String costBurn ) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType( String costType ) {
        this.costType = costType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public List<Object> getEffect() {
        return effect;
    }

    public void setEffect( List<Object> effect ) {
        this.effect = effect;
    }

    public List<String> getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn( List<String> effectBurn ) {
        this.effectBurn = effectBurn;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public LevelTipDto getLeveltip() {
        return leveltip;
    }

    public void setLeveltip( LevelTipDto leveltip ) {
        this.leveltip = leveltip;
    }

    public int getMaxrank() {
        return maxrank;
    }

    public void setMaxrank( int maxrank ) {
        this.maxrank = maxrank;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Object getRange() {
        return range;
    }

    public void setRange( Object range ) {
        this.range = range;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn( String rangeBurn ) {
        this.rangeBurn = rangeBurn;
    }

    public String getResource() {
        return resource;
    }

    public void setResource( String resource ) {
        this.resource = resource;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription( String sanitizedDescription ) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    public void setSanitizedTooltip( String sanitizedTooltip ) {
        this.sanitizedTooltip = sanitizedTooltip;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip( String tooltip ) {
        this.tooltip = tooltip;
    }

    public List<SpellVarsDto> getVars() {
        return vars;
    }

    public void setVars( List<SpellVarsDto> vars ) {
        this.vars = vars;
    }
}
