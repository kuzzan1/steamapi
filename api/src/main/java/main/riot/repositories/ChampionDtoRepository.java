package main.riot.repositories;

import main.URLBuilder;
import main.riot.domain.champion.ChampionDto;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jonas on 2016-11-30.
 */
@Repository
public class ChampionDtoRepository {

	@Autowired
	private RestTemplateBean restTemplateBean;

	@Autowired
	private MongoChampionDtoRepository mongochampionDtoRepository;

	public ChampionDto getChampionById(long championId, String locale) {
		ChampionDto champion = mongochampionDtoRepository.findByChampionId(championId);
		if (champion == null) {
			champion = getChampionFromAPI(championId, locale);
		} else if (champion.getTimestamp() * 60000 <= System.currentTimeMillis()) {
			champion = getChampionFromAPI(championId, locale);
		}
		return champion;
	}

	private ChampionDto getChampionFromAPI(long championId, String locale) {
		String url = new URLBuilder()
				.baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.2/champion")
				.Path("" + championId).buildRiot();
		ChampionDto champion = restTemplateBean.exchange(url, ChampionDto.class);
		champion.setTimestamp(System.currentTimeMillis());
		return champion;
	}
}
