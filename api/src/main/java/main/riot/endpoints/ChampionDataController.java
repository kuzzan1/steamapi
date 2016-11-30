package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.champion.ChampionDto;
import main.riot.enums.Locales;
import main.riot.repositories.ChampionDtoRepository;
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

    @Autowired
    private ChampionDtoRepository championDtoRepository;

    @RequestMapping( "/app/lol/{locale}/champion/{championId}" )
    public ChampionDto getChampion( @PathVariable( "championId" ) final long championId, @PathVariable final String locale ) throws Exception {
        if( Locales.contains( locale ) ) {
            ChampionDto champion = championDtoRepository.findByChampionId( championId );
            if( champion == null ) {
                champion = getChampionFromAPI( championId, locale );
            } else if( champion.getTimestamp() * 60000 <= System.currentTimeMillis() ) {
                champion = getChampionFromAPI( championId, locale );
            }
            return champion;
        }
        return null;
    }

    private ChampionDto getChampionFromAPI( @PathVariable( "championId" ) long championId, @PathVariable String locale ) {
        String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v1.2/champion" ).Path( ""+championId ).buildRiot();
        ChampionDto champion = restTemplateBean.exchange( url, ChampionDto.class );
        champion.setTimestamp( System.currentTimeMillis() );
        return champion;
    }

}
