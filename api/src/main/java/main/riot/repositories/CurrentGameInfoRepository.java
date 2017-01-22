package main.riot.repositories;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class CurrentGameInfoRepository {
	
    private static final int CURRENT_GAME_CACHE_MLSECS = 2 * 60 * 1000; // 5 minutes.
    
    @Autowired
    private RestTemplateBean restTemplateBean;
	
	@Autowired
	MongoCurrentGameInfoRepository mongocurrentgameinforepository;

	public CurrentGameInfo findBySummonerIdAndLocale(long summonerId, String locale) {
		CurrentGameInfo currentGameInfo = mongocurrentgameinforepository.findBySummonerIdAndLocale(summonerId, locale);
		if (currentGameInfo == null) {
			currentGameInfo = getCurrentGameInfoFromAPI(summonerId, locale);
		} else if (currentGameInfo.getTimestamp() + CURRENT_GAME_CACHE_MLSECS <= System.currentTimeMillis()) {
			currentGameInfo = getCurrentGameInfoFromAPI(summonerId, locale);
		}
		return currentGameInfo;
	}
	
	private CurrentGameInfo getCurrentGameInfoFromAPI(long summonerId, String locale ) {
        String url = new URLBuilder().baseUrl( "https://"+locale+".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+locale.toUpperCase()+"1").Path( String.valueOf( summonerId)).Param( "api_key", ApiKey.getRiotKey()).Build();
        CurrentGameInfo currentGameInfo = restTemplateBean.exchange(url, CurrentGameInfo.class);
        currentGameInfo.setTimestamp( System.currentTimeMillis() );
        currentGameInfo.setSummonerId(summonerId);
        currentGameInfo.setLocale(locale);
        
        if(currentGameInfo.getId() > 0)
        {
        	mongocurrentgameinforepository.save(currentGameInfo);
        }
        return currentGameInfo;
    }

}
