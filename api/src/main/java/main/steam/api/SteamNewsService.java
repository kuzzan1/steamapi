package main.steam.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.steam.bean.RestTemplateBean;
import main.steam.bean.SteamApiKey;


/**
 * Created by jonas on 2016-01-14.
 */

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class SteamNewsService {

    @Autowired
    RestTemplateBean restTemplateBean;

    private String URL = "https://api.steampowered.com/ISteamNews/";

    @RequestMapping("/app/news/{id}")
    public @ResponseBody
    String GetNewsForApp(@PathVariable("id") final String appId) {
        return restTemplateBean.exchange(URL + "GetNewsForApp/v2" + SteamApiKey.getApiKey() + "&appid=" + appId);
    }

}
