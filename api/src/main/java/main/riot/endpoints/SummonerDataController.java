package main.riot.endpoints;

import main.riot.domain.summoner.SummonerDto;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.SummonerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
public class SummonerDataController {

	@Autowired
	private SummonerRepository summonerRepository;

	@RequestMapping("app/lol/{locale}/summoner/{summonerName}")
	public SummonerDto getSummonerByName(@PathVariable final String summonerName, @PathVariable final String locale)
			throws UnsupportedLocaleException {
		if (Locales.contains(locale)) {
			return summonerRepository.findByLowerCaseNameAndLocale(summonerName, locale);
		}
		return null;
	}
}
