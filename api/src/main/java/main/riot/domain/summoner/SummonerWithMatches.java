package main.riot.domain.summoner;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.MatchList;
import main.riot.domain.match.MatchReference;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2016-11-20.
 */
public class SummonerWithMatches {

    @JsonProperty
    private SummonerDto summoner;
    @JsonProperty
    private List<MatchReference> matches = new ArrayList<>();
    @JsonProperty
    private int totalGames;
    @JsonProperty
    private  CurrentGameInfo currentGameInfo;

    public SummonerWithMatches(LinkedHashMap summonerDto, MatchList matchList, CurrentGameInfo currentGameInfo) {
        SummonerDto summonerCopy = new SummonerDto();
        summonerCopy.setId(Long.valueOf((Integer) summonerDto.get("id")));
        summonerCopy.setName((String) summonerDto.get("name"));
        summonerCopy.setProfileIconId((Integer) summonerDto.get("profileIconId"));
        summonerCopy.setSummonerLevel(Long.valueOf((Integer)summonerDto.get("summonerLevel")));
        this.summoner = summonerCopy;
        this.totalGames = matchList.getTotalGames();
        this.matches = matchList.getMatches();
        this.currentGameInfo = currentGameInfo;
    }

    public SummonerDto getSummoner() {
        return summoner;
    }

    public void setSummoner(SummonerDto summoner) {
        this.summoner = summoner;
    }

    public List<MatchReference> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchReference> matches) {
        this.matches = matches;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public CurrentGameInfo getCurrentGameInfo() {
        return currentGameInfo;
    }

    public void setCurrentGameInfo(CurrentGameInfo currentGameInfo) {
        this.currentGameInfo = currentGameInfo;
    }
}
