package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.shared.ImageDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class ChampionDto {

    @JsonProperty
    private List<String> allyTips = new ArrayList<>();
    @JsonProperty
    private String blurb;
    @JsonProperty
    private List<String> enemyTips = new ArrayList<>();
    @JsonProperty
    private ImageDto image;
    @JsonProperty
    private InfoDto info;
    @JsonProperty
    private String key;
    @JsonProperty
    private String lore;
    @JsonProperty
    private String name;
    @JsonProperty
    private String partype;
    @JsonProperty
    private PassiveDto passive;
    @JsonProperty
    private List<RecommendedDto> recommendedDtos = new ArrayList<>();
    @JsonProperty
    private List<SkinDto> skins = new ArrayList<>();
    @JsonProperty
    private List<ChampionSpellDto> spells = new ArrayList<>();
    @JsonProperty
    private StatsDto stats;
    @JsonProperty
    private List<String> tags = new ArrayList<>();
    @JsonProperty
    private String title;
    @JsonProperty
    private boolean active;
    @JsonProperty
    private boolean botEnabled;
    @JsonProperty
    private boolean botMmEnabled;
    @JsonProperty
    private boolean freeToPlay;
    @JsonProperty
    private boolean rankedPlayEnabled;
    @JsonProperty
    private long id;

    public List<String> getAllyTips() {
        return allyTips;
    }

    public void setAllyTips( List<String> allyTips ) {
        this.allyTips = allyTips;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb( String blurb ) {
        this.blurb = blurb;
    }

    public List<String> getEnemyTips() {
        return enemyTips;
    }

    public void setEnemyTips( List<String> enemyTips ) {
        this.enemyTips = enemyTips;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage( ImageDto image ) {
        this.image = image;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo( InfoDto info ) {
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getLore() {
        return lore;
    }

    public void setLore( String lore ) {
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype( String partype ) {
        this.partype = partype;
    }

    public PassiveDto getPassive() {
        return passive;
    }

    public void setPassive( PassiveDto passive ) {
        this.passive = passive;
    }

    public List<RecommendedDto> getRecommendedDtos() {
        return recommendedDtos;
    }

    public void setRecommendedDtos( List<RecommendedDto> recommendedDtos ) {
        this.recommendedDtos = recommendedDtos;
    }

    public List<SkinDto> getSkins() {
        return skins;
    }

    public void setSkins( List<SkinDto> skins ) {
        this.skins = skins;
    }

    public List<ChampionSpellDto> getSpells() {
        return spells;
    }

    public void setSpells( List<ChampionSpellDto> spells ) {
        this.spells = spells;
    }

    public StatsDto getStats() {
        return stats;
    }

    public void setStats( StatsDto stats ) {
        this.stats = stats;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags( List<String> tags ) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBotEnabled() {
        return botEnabled;
    }

    public void setBotEnabled(boolean botEnabled) {
        this.botEnabled = botEnabled;
    }

    public boolean isBotMmEnabled() {
        return botMmEnabled;
    }

    public void setBotMmEnabled(boolean botMmEnabled) {
        this.botMmEnabled = botMmEnabled;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public void setFreeToPlay(boolean freeToPlay) {
        this.freeToPlay = freeToPlay;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRankedPlayEnabled() {
        return rankedPlayEnabled;
    }

    public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
        this.rankedPlayEnabled = rankedPlayEnabled;
    }
}
