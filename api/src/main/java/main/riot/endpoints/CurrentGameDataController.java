package main.riot.endpoints;

import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.CurrentGameInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-19.
 */
@RestController
public class CurrentGameDataController {

    @Autowired
    private CurrentGameInfoRepository currentGameInfoRepository;
    

    //Todo clear currentGame when its inactive
    @RequestMapping("/app/lol/{locale}/current/game/{summonerId}")
    public CurrentGameInfo getCurrentGameInfo(@PathVariable final long summonerId, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
           return currentGameInfoRepository.findBySummonerIdAndLocale( summonerId, locale );
        }
        return null;
    }
}
