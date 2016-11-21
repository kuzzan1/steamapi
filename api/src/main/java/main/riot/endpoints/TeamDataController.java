package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-16.
 */
@RestController
public class TeamDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/{locale}/teams/{summonerIds}")
    public Map getTeamsData(@PathVariable("summonerIds") final String summonerIds, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.4/team/by-summoner/").Path(summonerIds).Param("api_key", ApiKey.getRiotKey()).Build();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }
}
