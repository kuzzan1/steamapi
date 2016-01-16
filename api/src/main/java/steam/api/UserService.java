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
public class UserService  {

    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2"+ SteamApiKey.getApiKey();

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping("app/{id}/summary")
    public @ResponseBody String getPlayerSummaries(@PathVariable("id") final String playerId) throws Exception{

        String innerUrl = URL + "&steamids=" + playerId;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }
}
