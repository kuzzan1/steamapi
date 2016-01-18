package main.steam.api;

import org.springframework.web.bind.annotation.*;
import main.steam.bean.RestTemplateBean;
import main.steam.bean.SteamApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

/**
 * Created by jonas on 2016-01-14.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class UserService  {

    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/ISteamUser/";

    @RequestMapping("/app/{id}/summary")
    public @ResponseBody String GetPlayerSummaries(@PathVariable("id") final String playerId) throws Exception{

        String innerUrl = URL + "GetPlayerSummaries/v2" + SteamApiKey.getApiKey() + "&steamids=" + playerId;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }

    @RequestMapping("/app/{username}/steamid")
    public @ResponseBody String ResolveVanityURL(@PathVariable("username") final String userName) throws Exception{

        String innerUrl = URL + "ResolveVanityURL/v0001/" + SteamApiKey.getApiKey() + "&vanityurl=" +userName;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                                          String.class).getBody();
    }


}
