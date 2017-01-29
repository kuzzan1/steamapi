package main.riot.repositories;

import main.URLBuilder;
import main.riot.domain.match.Match;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchRepository {

	private static final int MATCH_CACHE_MLSECS = 24 * 60 * 60 * 1000; // 24 hours.

	@Autowired
	private RestTemplateBean restTemplateBean;

	@Autowired
	private MongoMatchRepository mongoMatchRepository;

	public Match findByMatchIdAndLocale(Long matchId, String locale) {
		Match match = mongoMatchRepository.findByMatchIdAndLocale(matchId, locale);
		if (match == null) {
			match = getMatchFromApi(matchId, locale);
		} else {
			if (match.getTimestamp() + MATCH_CACHE_MLSECS <= System.currentTimeMillis()) {
				match = getMatchFromApi(matchId, locale);
			}
		}
		return match;
	}

	private Match getMatchFromApi(Long matchId, String locale) {
		String url = new URLBuilder().baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v2.2/match")
				.Path(String.valueOf(matchId)).buildRiot();
		Match match = restTemplateBean.exchange(url, Match.class);
		match.setTimestamp(System.currentTimeMillis());
		match.setLocale(locale);
		if (match.getId() > 0) {
			mongoMatchRepository.save(match);
		}
		return match;
	}

}
