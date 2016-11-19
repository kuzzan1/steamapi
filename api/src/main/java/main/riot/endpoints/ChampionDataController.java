package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.champion.ChampionDto;
import main.riot.domain.champion.ChampionListDto;
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

    @RequestMapping("/app/lol/champions")
    public ChampionListDto getChampions() throws Exception {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.2/champion" ).buildRiot();
        return restTemplateBean.exchange(url, ChampionListDto.class);
    }

    @RequestMapping("/app/lol/champion/{championId}")
    public ChampionDto getChampion(@PathVariable("championId") final String championId ) throws Exception {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.2/champion" ).Path( championId ).buildRiot();
        return restTemplateBean.exchange(url, ChampionDto.class);
    }

    @RequestMapping("/app/lol/champions/static")
    public ChampionListDto getChampionsStatic() throws Exception {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/champion" ).Param( "champDat", "all").buildRiot();
        return restTemplateBean.exchange(url, ChampionListDto.class);
    }
}
