package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-19.
 */
@RestController
public class CurrentGameDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/current/game/{summonerId}")
    public CurrentGameInfo getCurrentGameInfo(@PathVariable final Long summonerId) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/EUN1").Path(String.valueOf(summonerId)).Param("api_key", ApiKey.getRiotKey()).Build();
        return restTemplateBean.exchange(url, CurrentGameInfo.class);
    }
}
