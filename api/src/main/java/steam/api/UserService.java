package steam.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import steam.bean.RestTemplateBean;
import steam.bean.SteamApiKey;

/**
 * Created by jonas on 2016-01-14.
 */
@RestController
public class UserService {

    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2?key="+ SteamApiKey.getApiKey();

    @RequestMapping("app/{id}/summary")
    public String getPlayerSummaries(@PathVariable("id") final String playerId) throws Exception{

        String innerUrl = URL + "&steamids=" + playerId;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }
}
