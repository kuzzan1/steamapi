package main.java.steam.api;

import steam.bean.RestTemplateBean;
import steam.bean.SteamApiKey;
import steam.filter.CORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-01-14.
 */
@RestController
public class PlayerService extends CORSFilter {

    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1?key="+ SteamApiKey.getApiKey();

    @RequestMapping("app/{id}/playedGames/{count}")
    public String getPlayedGamesWithCOunt(@PathVariable("id") final String playerId, @PathVariable("count") final String count) throws Exception{
        String innerCount = count != null ? "&count=" + count : "";
        String innerUrl = URL + "&steamid=" + playerId+ innerCount;

        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }

}
