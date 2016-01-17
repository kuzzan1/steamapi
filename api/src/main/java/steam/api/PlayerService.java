package steam.api;

import org.springframework.web.bind.annotation.*;
import steam.bean.RestTemplateBean;
import steam.bean.SteamApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

/**
 * Created by jonas on 2016-01-14.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class PlayerService {

    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1"+ SteamApiKey.getApiKey();

    @RequestMapping("app/{id}/playedGames/{count}")
    public @ResponseBody String GetRecentlyPlayedGames(@PathVariable("id") final String playerId, @PathVariable("count") final String count) throws Exception{
        String innerCount = count != null ? "&count=" + count : "";
        String innerUrl = URL + "&steamid=" + playerId+ innerCount;

        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }

}
