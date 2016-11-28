package main.riot.domain.summoner;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-20.
 */
public class SummonerWithMatches {

    @JsonProperty
    private SummonerDto summoner;
    @JsonProperty
    private List<MatchReference> matchReferences = new ArrayList<>();
    @JsonProperty
    private int totalGames;
    @JsonProperty
    private  CurrentGameInfo currentGameInfo;
    @JsonProperty
    private List<Match> matches = new ArrayList<>();

    public SummonerWithMatches(SummonerDto summonerDto, int totalGames, CurrentGameInfo currentGameInfo, List<Match> deeperMatchList) {
        this.summoner = summonerDto;
        this.totalGames = totalGames;
//        this.matchReferences = matchList.getMatches();
        this.currentGameInfo = currentGameInfo;
        this.matches = deeperMatchList;
    }

    public SummonerDto getSummoner() {
        return summoner;
    }

    public void setSummoner(SummonerDto summoner) {
        this.summoner = summoner;
    }

  /*  public List<MatchReference> getMatchReferences() {
        return matchReferences;
    }

    public void setMatchReferences(List<MatchReference> matchReferences) {
        this.matchReferences = matchReferences;
    }*/

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

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
