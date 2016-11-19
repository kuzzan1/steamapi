package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.game.RecentGamesDto;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-19.
 */
@RestController
public class GameDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/games/{summonerId}/recent")
    public RecentGamesDto getGamesData(@PathVariable("summonerId") final String summonerId) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v1.3/game/by-summoner/").Path(summonerId).Path("recent").Param("api_key", ApiKey.getRiotKey()).Build();
        return restTemplateBean.exchange(url, RecentGamesDto.class);
    }
}
