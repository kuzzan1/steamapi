package main.riot.repositories;

import main.URLBuilder;
import main.riot.domain.match.MatchList;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchListRepository {

	private static final int MATCHLIST_CACHE_MLSECS = 60 * 60 * 1000; // 1 hour.

	@Autowired
	private RestTemplateBean restTemplateBean;

	@Autowired
	MongoMatchListRepository mongoMatchListRepository;

	public MatchList findBySummonerIdAndLocale(long summonerId, String locale) {
		MatchList matchList = mongoMatchListRepository.findBySummonerIdAndLocale(summonerId, locale);
		if (matchList == null) {
			matchList = getMatchListFromApi(summonerId, locale);
		} else {
			if (matchList.getTimestamp() + MATCHLIST_CACHE_MLSECS <= System.currentTimeMillis()) {
				matchList = getMatchListFromApi(summonerId, locale);
			}
		}
		return matchList;
	}

	private MatchList getMatchListFromApi(long summonerId, String locale) {
		String url = new URLBuilder()
				.baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v2.2/matchlist/by-summoner")
				.Path(String.valueOf(summonerId)).buildRiot();
		MatchList matchList = restTemplateBean.exchange(url, MatchList.class);
		matchList.setSummonerId(summonerId);
		matchList.setLocale(locale);
		matchList.setTimestamp(System.currentTimeMillis());
		if (matchList.getMatches().size() > 0) {
			mongoMatchListRepository.save(matchList);
		}
		return matchList;
	}
}
