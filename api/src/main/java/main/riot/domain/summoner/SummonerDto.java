package main.riot.domain.summoner;

import java.util.HashMap;

import main.riot.domain.Timestamp;

import org.springframework.data.annotation.Id;

/**
 * Created by jonas on 2016-11-17.
 */
public class SummonerDto extends Timestamp {

    @Id
    private long id;
    private String name;
    private int profileIconId;
    private long summonerLevel;

    private String lowerCaseName;
    private String locale;


    public SummonerDto() {
    }

    public SummonerDto( HashMap<?, ?> summonerDto, String locale ) {
        this.setId(Long.valueOf((Integer) summonerDto.get("id")));
        this.setName((String) summonerDto.get("name"));
        this.setProfileIconId((Integer) summonerDto.get("profileIconId"));
        this.setSummonerLevel(Long.valueOf((Integer)summonerDto.get("summonerLevel")));
        this.setLowerCaseName( this.getName().toLowerCase() );
        this.setLocale(locale);
    }


    public String getLowerCaseName() {
        return lowerCaseName;
    }

    public void setLowerCaseName( String lowerCaseName ) {
        this.lowerCaseName = lowerCaseName;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId( int profileIconId ) {
        this.profileIconId = profileIconId;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel( long summonerLevel ) {
        this.summonerLevel = summonerLevel;
    }

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
