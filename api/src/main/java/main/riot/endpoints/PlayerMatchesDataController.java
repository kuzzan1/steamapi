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
	public List<Double> getSummonersWinRateCurrentMatch(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			SummonerDto summoner = summonerDataController.getSummonerByName(summonerName, locale);
			IMatchInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summoner.getId(), locale);

			if (currentGameInfo.getId() == 0) {
				List<Match> lastMatch = getLatestMatches(locale, matchDataController.getMatchList(summoner.getId(), locale), 1);
				if (lastMatch.size() > 0) {
					currentGameInfo = lastMatch.get(0);
				}
			}

			return getPercForCurrentOrLastMatch(locale, currentGameInfo);
		}
		return null;
	}

    private List<Double> getPercForCurrentOrLastMatch(final String locale, IMatchInfo currentGameInfo) throws UnsupportedLocaleException {
		Long homeTeamId = null;
		Map<Long, List<Match>> homeTeamMatches = new HashMap<>();
		Map<Long, List<Match>> awayTeamMatches = new HashMap<>();
		List<Double> homeTeamWinRates = new ArrayList<>();
		List<Double> awayTeamWinRates = new ArrayList<>();

		for (IParticipant currentGameParticipant : currentGameInfo.getMatchParticipants()) {
			sleep();
			MatchList matchList = matchDataController.getMatchList(currentGameParticipant.getSummonerId(), locale);
			if (!matchList.getMatches().isEmpty()) {
				if (homeTeamId == null) {
					homeTeamId = currentGameParticipant.getTeamId();
				}
				if (currentGameParticipant.getTeamId() == homeTeamId) {
					homeTeamMatches.put(currentGameParticipant.getSummonerId(), getLatestMatches(locale, matchList, 1));
				} else {
					awayTeamMatches.put(currentGameParticipant.getSummonerId(), getLatestMatches(locale, matchList, 1));
				}
			}
			sleep();
		}

		for (Map.Entry<Long, List<Match>> summonerMatches : homeTeamMatches.entrySet()) {
			homeTeamWinRates.add(getWinRateForSummoner(summonerMatches.getValue(), summonerMatches.getKey()));
		}
		for (Map.Entry<Long, List<Match>> summonerMatches : awayTeamMatches.entrySet()) {
			awayTeamWinRates.add(getWinRateForSummoner(summonerMatches.getValue(), summonerMatches.getKey()));
		}
		return getPercForTeamsWinRate(homeTeamWinRates, awayTeamWinRates);
	}

	private List<Double> getPercForTeamsWinRate(List<Double> homeTeamWinRate, List<Double> awayTeamWinRate) {
		return WinPercentageCalculator.calculateTeamWinPercents(toDoubleArray(homeTeamWinRate), toDoubleArray(awayTeamWinRate));
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
