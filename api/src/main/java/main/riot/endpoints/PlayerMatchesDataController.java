package main.riot.endpoints;

import main.riot.calculator.WinPercentageCalculator;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.currentgame.CurrentGameParticipant;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.riot.domain.match.MatchReference;
import main.riot.domain.summoner.SummonerWithMatches;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.helper.PlayerWinHelper;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by jonas on 2016-11-20.
 */
@RestController
public class PlayerMatchesDataController {


    @Autowired
    private RestTemplateBean restTemplateBean;

    @Autowired
    private SummonerDataController summonerDataController;

    @Autowired
    private MatchDataController matchDataController;

    @Autowired
    private CurrentGameDataController currentGameDataController;

    @Autowired
    private PlayerWinHelper playerWinHelper;

    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/matches")
    public SummonerWithMatches getPlayerMatchData(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));

            sleep();

            MatchList matchList = matchDataController.getMatchList(summonerId, locale);
            List<Match> deeperMatchList = get7LatestMatches(locale, matchList);
            sleep();

            CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId, locale);

            return new SummonerWithMatches(summoner, matchList.getTotalGames(), currentGameInfo, deeperMatchList);
        }
        return null;
    }

    private List<Match> get7LatestMatches(@PathVariable String locale, MatchList matchList) throws UnsupportedLocaleException {
        List<Match> deeperMatchList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            MatchReference matchReference = matchList.getMatches().get(i);
            sleep();
            deeperMatchList.add(matchDataController.getMatch(matchReference.getMatchId(), locale));
        }
        return deeperMatchList;
    }


    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/winRate")
    public double getSummonersWinRate(@PathVariable final String summonerName, @PathVariable final String locale ) throws UnsupportedLocaleException{
        if(Locales.contains(locale)) {
            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));
            sleep();
            List<Match> latestMatches = get7LatestMatches(locale, matchDataController.getMatchList(summonerId, locale));
            return getWinRateForSummoner(latestMatches, summonerId);
        }
        return -1;
    }


    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/winRate/currentMatch")
    public Map<Long, List<Double>> getSummonersWinRateCurrentMatch(@PathVariable final String summonerName, @PathVariable final String locale ) throws UnsupportedLocaleException{
        if( Locales.contains( locale )) {
            Map<Long, List<Double>> teamWinRates = new HashMap<>();

            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));
            Map<Long, Map<Long, List<Match>>> teamMatches = new HashMap<>();

            CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId, locale);

            for (CurrentGameParticipant currentGameParticipant : currentGameInfo.getParticipants()) {
                MatchList matchList = matchDataController.getMatchList(currentGameParticipant.getSummonerId(), locale);

                if(teamMatches.get(currentGameParticipant.getTeamId()) == null) {
                    teamMatches.put(currentGameParticipant.getTeamId(), new HashMap<>());
                }
                if(!matchList.getMatches().isEmpty()) {
                    teamMatches.get(currentGameParticipant.getTeamId()).put(currentGameParticipant.getSummonerId(), get7LatestMatches(locale, matchList));
                }
                else {
                    teamMatches.get(currentGameParticipant.getTeamId()).put(currentGameParticipant.getSummonerId(), new ArrayList<>());
                }
                sleep();
            }

            for (Map.Entry<Long, Map<Long, List<Match>>> teamsSummonersMap : teamMatches.entrySet()) {
                Map<Long, List<Match>> teamSummonerMatches = teamsSummonersMap.getValue();
                for (Map.Entry<Long, List<Match>> summonerMatches : teamSummonerMatches.entrySet()) {
                    if(teamWinRates.get(teamsSummonersMap.getKey()) == null) {
                        teamWinRates.put(teamsSummonersMap.getKey(), new ArrayList<>());
                    }
                    teamWinRates.get(teamsSummonersMap.getKey()).add(getWinRateForSummoner(summonerMatches.getValue(), summonerMatches.getKey()));
                }
            }
            return teamWinRates;
        }
        return null;

    }



    private double getWinRateForSummoner(List<Match> lastMatches, long summonerId) {
        Boolean[] playerLastMatches = playerWinHelper.getPlayerLastMatches(lastMatches, summonerId);
        WinPercentageCalculator winPercentageCalculator = new WinPercentageCalculator();
        return winPercentageCalculator.getWinPercentOnPlayer(playerLastMatches);
    }

    private void sleep() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}
