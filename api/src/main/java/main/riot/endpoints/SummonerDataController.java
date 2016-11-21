package main.riot.endpoints;

import main.URLBuilder;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
public class SummonerDataController {

    //42893043 - summoner id

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("app/lol/{locale}/summoner/{summonerName}")
    public Map<String, LinkedHashMap> getSummonerByName(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            String url = new URLBuilder().baseUrl( "https://"+locale+".api.pvp.net/api/lol/"+locale+"/v1.4/summoner/by-name" ).Path( summonerName ).buildRiot();
            return restTemplateBean.exchange( url, HashMap.class);
        }
        return null;
    }
}
