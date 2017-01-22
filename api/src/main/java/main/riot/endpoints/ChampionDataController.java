package main.riot.endpoints;

import main.riot.domain.champion.ChampionDto;
import main.riot.enums.Locales;
import main.riot.repositories.ChampionDtoRepository;

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
	private ChampionDtoRepository championDtoRepository;

    @RequestMapping( "/app/lol/{locale}/champion/{championId}" )
    public ChampionDto getChampion( @PathVariable( "championId" ) final long championId, @PathVariable final String locale ) throws Exception {
        if( Locales.contains( locale ) ) {
            return championDtoRepository.getChampionById(championId, locale);
        }
        return null;
    }
}
