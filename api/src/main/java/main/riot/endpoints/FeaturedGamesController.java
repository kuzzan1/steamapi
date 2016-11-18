package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.featured.FeaturedGames;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-18.
 */
@RestController
public class FeaturedGamesController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("app/lol/matches/featured")
    public FeaturedGames getFeaturedGames() {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/observer-mode/rest/featured" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, FeaturedGames.class );
    }
}
