package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.champion.Champion;
import main.riot.domain.champion.ChampionListDto;
import main.riot.domain.champion.Champions;
import main.steam.bean.RestTemplateBean;
import main.toornament.security.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jonas on 2016-11-16.
 */
@RestController
public class ChampionService {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/champions")
    public List getChampions() throws Exception {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.2/champion" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange(url, Champions.class).getChampions();
    }

    @RequestMapping("/app/lol/champion/{championId}")
    public Champion getChampion( @PathVariable("championId") final String championId ) throws Exception {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.2/champion" ).Path( championId ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange(url, Champion.class);
    }

    @RequestMapping("/app/lol/champions/static")
    public ChampionListDto getChampionsStatic() throws Exception {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/champion" ).Param( "champDat", "all").Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange(url, ChampionListDto.class);
    }
}
