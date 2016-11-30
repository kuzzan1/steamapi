package main.riot.domain.champion;

import main.riot.domain.Timestamp;
import main.riot.domain.shared.ImageDto;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
public class ChampionDto extends Timestamp {

    @Id
    private long championId;
    private String blurb;
    private ImageDto image;
    private InfoDto info;
    private String key;
    private String lore;
    private String name;
    private String partype;
    private PassiveDto passive;
    private StatsDto stats;
    private List<String> tags = new ArrayList<>();
    private String title;
    private boolean active;
    private boolean botEnabled;
    private boolean botMmEnabled;
    private boolean freeToPlay;
    private boolean rankedPlayEnabled;
    private List<String> enemyTips = new ArrayList<>();
    private List<String> allyTips = new ArrayList<>();
    private List<RecommendedDto> recommendedDtos = new ArrayList<>();
    private List<SkinDto> skins = new ArrayList<>();
    private List<ChampionSpellDto> spells = new ArrayList<>();

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

    public void setChampionId( long championId ) {
        this.championId = championId;
    }

    public long getChampionId() {
        return championId;
    }

    public boolean isRankedPlayEnabled() {
        return rankedPlayEnabled;
    }

    public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
        this.rankedPlayEnabled = rankedPlayEnabled;
    }
}
