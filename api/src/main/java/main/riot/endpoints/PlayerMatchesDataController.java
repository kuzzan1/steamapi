package main.riot.endpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.riot.calculator.WinPercentageCalculator;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.IMatchInfo;
import main.riot.domain.match.IParticipant;
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
    public Object getPlayerMatchData(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));

            sleep();

            MatchList matchList = matchDataController.getMatchList(summonerId, locale);
            List<Match> deeperMatchList = getLatestMatches(locale, matchList, 1);
            sleep();

            CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId, locale);

            return new SummonerWithMatches(summoner, matchList.getTotalGames(), currentGameInfo, deeperMatchList);
        }
        return null;
    }

    private List<Match> getLatestMatches(@PathVariable String locale, MatchList matchList, int number) throws UnsupportedLocaleException {
        List<Match> deeperMatchList = new ArrayList<>();
        for (int i = 0; i < number && i < matchList.getMatches().size(); i++) {
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
            List<Match> latestMatches = getLatestMatches(locale, matchDataController.getMatchList(summonerId, locale), 1);
            return getWinRateForSummoner(latestMatches, summonerId);
        }
        return -1;
    }


    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/winRate/currentMatch")
    public List<Double> getSummonersWinRateCurrentMatch(@PathVariable final String summonerName, @PathVariable final String locale ) throws UnsupportedLocaleException{
        if( Locales.contains( locale )) {
            Map<Long, List<Double>> teamWinRates = new HashMap<>();

            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));
            Map<Long, Map<Long, List<Match>>> teamMatches = new HashMap<>();

			IMatchInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId, locale);

			if (currentGameInfo.getId() == 0) {
				List<Match> lastMatch = getLatestMatches(locale, matchDataController.getMatchList(summonerId, locale), 1);
				if (lastMatch.size() > 0) {
					currentGameInfo = lastMatch.get(0);
				}
			}

            for (IParticipant currentGameParticipant : currentGameInfo.getMatchParticipants()) {
                MatchList matchList = matchDataController.getMatchList(currentGameParticipant.getSummonerId(), locale);

                if(teamMatches.get(currentGameParticipant.getTeamId()) == null) {
                    teamMatches.put(currentGameParticipant.getTeamId(), new HashMap<>());
                }
                if(!matchList.getMatches().isEmpty()) {
                    teamMatches.get(currentGameParticipant.getTeamId()).put(currentGameParticipant.getSummonerId(), getLatestMatches(locale, matchList, 1));
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
          return getPercForTeamsWinRate(teamWinRates);
        }
        return null;
    }

	private List<Double> getPercForTeamsWinRate(Map<Long, List<Double>> teamWinRates) {
		List<Double> team1 = new ArrayList<>();
		List<Double> team2 = new ArrayList<>();
		
		int i = 0;
		for (List<Double> value : teamWinRates.values()) {
			if (i == 0) {
				team1 = value;
			} else {
				team2 = value;
				break;
			}
			i++;
		}
		
		  WinPercentageCalculator calc = new WinPercentageCalculator();            
          return Arrays.asList(calc.calculateTeamWinPercents(toDoubleArray(team1), toDoubleArray(team2)));
	}
	
	double[] toDoubleArray(List<Double> list) {
		double[] ret = new double[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}


    private double getWinRateForSummoner(List<Match> lastMatches, long summonerId) {
        Boolean[] playerLastMatches = playerWinHelper.getPlayerLastMatches(lastMatches, summonerId);
        WinPercentageCalculator winPercentageCalculator = new WinPercentageCalculator();
        return winPercentageCalculator.getWinPercentOnPlayer(playerLastMatches);
    }

    private void sleep() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
