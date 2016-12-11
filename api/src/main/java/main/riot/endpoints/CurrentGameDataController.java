package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.CurrentGameInfoRepository;
import main.steam.bean.RestTemplateBean;
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
    private RestTemplateBean restTemplateBean;

    @Autowired
    private CurrentGameInfoRepository currentGameInfoRepository;
    private static final int CURRENT_GAME_CACHE_MLSECS = 2 * 60 * 1000; // 5 minutes.



    //Todo clear currentGame when its inactive
    @RequestMapping("/app/lol/{locale}/current/game/{summonerId}")
    public CurrentGameInfo getCurrentGameInfo(@PathVariable final long summonerId, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            CurrentGameInfo currentGameInfo = currentGameInfoRepository.findBySummonerIdAndLocale( summonerId, locale );
            if( currentGameInfo == null) {
                currentGameInfo = getCurrentGameInfoFromAPI( summonerId, locale );
            } else if(currentGameInfo.getTimestamp() + CURRENT_GAME_CACHE_MLSECS <= System.currentTimeMillis()) {
                currentGameInfo = getCurrentGameInfoFromAPI( summonerId, locale );
            }
            return currentGameInfo;
        }
        return null;
    }

    private CurrentGameInfo getCurrentGameInfoFromAPI( @PathVariable long summonerId, @PathVariable String locale ) {
        String url = new URLBuilder().baseUrl( "https://"+locale+".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+locale.toUpperCase()+"1").Path( String.valueOf( summonerId)).Param( "api_key", ApiKey.getRiotKey()).Build();
        CurrentGameInfo currentGameInfo = restTemplateBean.exchange(url, CurrentGameInfo.class);
        currentGameInfo.setTimestamp( System.currentTimeMillis() );
        currentGameInfo.setSummonerId(summonerId);
        currentGameInfo.setLocale(locale);
        
        if(currentGameInfo.getId() > 0)
        {
        	currentGameInfoRepository.save(currentGameInfo);
        }
        return currentGameInfo;
    }
}
