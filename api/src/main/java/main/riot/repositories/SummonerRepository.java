package main.riot.repositories;

import java.util.HashMap;

import main.URLBuilder;
import main.riot.domain.summoner.SummonerDto;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class SummonerRepository {
	
	private static final int SUMMONER_CACHE_MLSECS = 24 * 60 * 60 * 1000; // 1 day.

	@Autowired
	private RestTemplateBean restTemplateBean;
	
	@Autowired
	private MongoSummonerRepository mongoSummonerRepository;


	public SummonerDto findByLowerCaseNameAndLocale(String summonerName, String locale) {
		SummonerDto summonerDto = mongoSummonerRepository.findByLowerCaseNameAndLocale(summonerName, locale);
		if (summonerDto == null) {
			summonerDto = getSummonerFromAPI(summonerName, locale);
		} else if (summonerDto.getTimestamp() + SUMMONER_CACHE_MLSECS <= System.currentTimeMillis()) {
			summonerDto = getSummonerFromAPI(summonerName, locale);
		}
		return summonerDto;
	}

	private SummonerDto getSummonerFromAPI(@PathVariable String summonerName, @PathVariable String locale) {
		SummonerDto summonerDto;
		String url = new URLBuilder().baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.4/summoner/by-name").Path(summonerName).buildRiot();
		HashMap<?, ?> exchange = restTemplateBean.exchange(url, HashMap.class);
		if (exchange.size() > 0) {
			summonerDto = new SummonerDto((HashMap<?, ?>) exchange.get(summonerName), locale);
			summonerDto.setTimestamp(System.currentTimeMillis());
			if (summonerDto.getId() > 0) {
				mongoSummonerRepository.save(summonerDto);
			}
			return summonerDto;
		}
		else return null;
	}

}
