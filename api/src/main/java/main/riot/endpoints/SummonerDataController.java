package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.summoner.SummonerDto;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.SummonerRepository;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
public class SummonerDataController {

	// 42893043 - summoner id
	private static final int SUMMONER_CACHE_MLSECS = 24 * 60 * 60 * 1000; // 1
																			// day.

	@Autowired
	private SummonerRepository summonerRepository;

	@Autowired
	private RestTemplateBean restTemplateBean;

	@RequestMapping("app/lol/{locale}/summoner/{summonerName}")
	public SummonerDto getSummonerByName(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			SummonerDto summonerDto = summonerRepository.findByLowerCaseNameAndLocale(summonerName, locale);
			if (summonerDto == null) {
				summonerDto = getSummonerFromAPI(summonerName, locale);
			} else if (summonerDto.getTimestamp() + SUMMONER_CACHE_MLSECS <= System.currentTimeMillis()) {
				summonerDto = getSummonerFromAPI(summonerName, locale);
			}
			return summonerDto;
		}
		return null;
	}

	private SummonerDto getSummonerFromAPI(@PathVariable String summonerName, @PathVariable String locale) {
		SummonerDto summonerDto;
		String url = new URLBuilder().baseUrl("https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.4/summoner/by-name").Path(summonerName).buildRiot();
		HashMap exchange = restTemplateBean.exchange(url, HashMap.class);
		if (exchange.size() > 0) {
			summonerDto = new SummonerDto((LinkedHashMap) exchange.get(summonerName), locale);
			summonerDto.setTimestamp(System.currentTimeMillis());
			if (summonerDto.getId() > 0) {
				summonerRepository.save(summonerDto);
			}
			return summonerDto;
		}
		else return null;
	}
}
