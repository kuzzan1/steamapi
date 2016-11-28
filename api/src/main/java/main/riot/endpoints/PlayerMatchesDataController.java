package main.riot.endpoints;

import main.riot.calculator.WinPercentageCalculator;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.*;
import main.riot.domain.summoner.SummonerDto;
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
    public Object getPlayerMatchData(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            SummonerDto summoner = summonerDataController.getSummonerByName( summonerName, locale );

            sleep();

            MatchList matchList = matchDataController.getMatchList(summoner.getId(), locale);
            List<Match> deeperMatchList = getLatestMatches(locale, matchList, 1);
            sleep();

            CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summoner.getId(), locale);

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
            SummonerDto summoner = summonerDataController.getSummonerByName( summonerName, locale );
            sleep();
            List<Match> latestMatches = getLatestMatches(locale, matchDataController.getMatchList(summoner.getId(), locale), 1);
            return getWinRateForSummoner(latestMatches, summoner.getId());
        }
        return -1;
    }


    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/winRate/currentMatch")
    public List<Double> getSummonersWinRateCurrentMatch(@PathVariable final String summonerName, @PathVariable final String locale ) throws UnsupportedLocaleException{
        if( Locales.contains( locale )) {
            Map<Long, List<Double>> teamWinRates = new HashMap<>();

            SummonerDto summoner = summonerDataController.getSummonerByName( summonerName, locale );

            Map<Long, Map<Long, List<Match>>> teamMatches = new HashMap<>();

			IMatchInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summoner.getId(), locale);

			if (currentGameInfo.getId() == 0) {
				List<Match> lastMatch = getLatestMatches(locale, matchDataController.getMatchList(summoner.getId(), locale), 1);
				if (lastMatch.size() > 0) {
					currentGameInfo = lastMatch.get(0);
				}
			}

            for (IParticipant currentGameParticipant : currentGameInfo.getMatchParticipants()) {
                MatchList matchList = matchDataController.getMatchList(currentGameParticipant.getSummonerId(), locale);

                teamMatches.putIfAbsent( currentGameParticipant.getTeamId(), new HashMap<>() );
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
                    teamWinRates.putIfAbsent( teamsSummonersMap.getKey(), new ArrayList<>() );
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

          return WinPercentageCalculator.calculateTeamWinPercents(toDoubleArray(team1), toDoubleArray(team2));
	}
	
	private double[] toDoubleArray(List<Double> list) {
		double[] ret = new double[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}


    private double getWinRateForSummoner(List<Match> lastMatches, long summonerId) {
        Boolean[] playerLastMatches = playerWinHelper.getPlayerLastMatches(lastMatches, summonerId);
        return WinPercentageCalculator.getWinPercentOnPlayer(playerLastMatches);
    }

    private void sleep() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
