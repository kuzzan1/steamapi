package main.riot.endpoints;

import main.riot.domain.game.RecentGamesDto;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.MatchListRepository;
import main.riot.repositories.MatchRepository;
import main.riot.repositories.RecentGamesDtoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-16.
 */
@RestController
public class MatchDataController {

	@Autowired
	private MatchRepository matchRepository;
	@Autowired
	private MatchListRepository matchListRepository;
	@Autowired
	private RecentGamesDtoRepository recentGamesDtoRepository;

	@RequestMapping("/app/lol/{locale}/match/{matchId}")
	public Match getMatch(@PathVariable("matchId") final Long matchId, @PathVariable final String locale)
			throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			return matchRepository.findByMatchIdAndLocale(matchId, locale);
		}
		return null;

	}

	@RequestMapping("/app/lol/{locale}/match/summoner/{summonerId}")
	public MatchList getMatchList(@PathVariable final long summonerId, @PathVariable final String locale)
			throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			return matchListRepository.findBySummonerIdAndLocale(summonerId, locale);
		}
		return null;
	}

	@RequestMapping("/app/lol/{locale}/games/{summonerId}/recent")
	public RecentGamesDto getGamesData(@PathVariable("summonerId") final long summonerId,
			@PathVariable final String locale) throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			return recentGamesDtoRepository.findBySummonerIdAndLocale(summonerId, locale);
		}
		return null;
	}
}
