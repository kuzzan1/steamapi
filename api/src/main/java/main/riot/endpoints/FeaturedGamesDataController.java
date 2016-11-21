package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.featured.FeaturedGames;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-18.
 */
@RestController
public class FeaturedGamesDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping( "app/lol/{locale}/matches/featured" )
    public FeaturedGames getFeaturedGames( @PathVariable final String locale ) throws UnsupportedLocaleException {
        if( Locales.contains( locale ) ) {
            String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/observer-mode/rest/featured" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
            return restTemplateBean.exchange( url, FeaturedGames.class );
        }
        return null;
    }
}
