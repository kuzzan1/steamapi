package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.champion.ChampionDto;
import main.riot.domain.champion.ChampionListDto;
import main.riot.enums.Locales;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-16.
 */
@RestController
public class ChampionDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;


    @RequestMapping( "/app/lol/{locale}/champions" )
    public ChampionListDto getChampions( @PathVariable final String locale ) throws Exception{
        if( Locales.contains( locale ) ) {
            String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.2/champion" ).buildRiot();
            return restTemplateBean.exchange( url, ChampionListDto.class );
        }
        return null;
    }

    @RequestMapping( "/app/lol/{locale}/champion/{championId}" )
    public ChampionDto getChampion( @PathVariable( "championId" ) final String championId, @PathVariable final String locale ) throws Exception {
        if( Locales.contains( locale ) ) {
            String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.2/champion" ).Path( championId ).buildRiot();
            return restTemplateBean.exchange( url, ChampionDto.class );
        }
        return null;
    }


}
