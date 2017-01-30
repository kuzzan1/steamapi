package main.riot.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import main.URLBuilder;
import main.riot.domain.game.RecentGamesDto;
import main.steam.bean.RestTemplateBean;

@Repository
public class RecentGamesDtoRepository {

	private static final int RECENT_MATCHES_CACHE_MLSECS = 60 * 1000; // 1 minute.

	@Autowired
	private RestTemplateBean restTemplateBean;

	@Autowired
	MongoRecentGamesDtoRepository mongoRecentGamesDtoRepository;

	public RecentGamesDto findBySummonerIdAndLocale(long summonerId, String locale) {
		RecentGamesDto recentGamesDto = mongoRecentGamesDtoRepository.findBySummonerIdAndLocale(summonerId, locale);
		if (recentGamesDto == null) {
			recentGamesDto = getRecentGamesDtoFromAPI(summonerId, locale);
		} else if (recentGamesDto.getTimestamp() + RECENT_MATCHES_CACHE_MLSECS <= System.currentTimeMillis()) {
			recentGamesDto = getRecentGamesDtoFromAPI(summonerId, locale);
		}
		return recentGamesDto;
	}

	private RecentGamesDto getRecentGamesDtoFromAPI(@PathVariable("summonerId") long summonerId,
			@PathVariable String locale) {
		RecentGamesDto recentGamesDto;
		String url = new URLBuilder()
				.baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.3/game/by-summoner/")
				.Path(summonerId).Path("recent").buildRiot();
		recentGamesDto = restTemplateBean.exchange(url, RecentGamesDto.class);
		recentGamesDto.setTimestamp(System.currentTimeMillis());
		recentGamesDto.setLocale(locale);
		return recentGamesDto;
	}

}
