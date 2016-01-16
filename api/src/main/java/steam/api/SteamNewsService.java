package main.java.steam.api;

import main.java.steam.bean.RestTemplateBean;
import main.java.steam.bean.SteamApiKey;
import main.java.steam.filter.CORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jonas on 2016-01-14.
 */

@RestController
public class SteamNewsService extends CORSFilter {

    @Autowired
    RestTemplateBean restTemplateBean;

    private String URL = "https://api.steampowered.com/ISteamNews/";

    @RequestMapping("/app/news/{id}")
    public String getNewsForApp(@PathVariable("id") final String appId) {
        return restTemplateBean.exchange(URL + "GetNewsForApp/v2?key=" + SteamApiKey.getApiKey() + "&appid=" + appId);
    }

}
