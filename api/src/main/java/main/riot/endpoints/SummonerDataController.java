package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.summoner.SummonerDto;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
public class SummonerDataController {

    //42893043 - summoner id

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("app/lol/summoner/{summonerName}")
    public SummonerDto getSummonerByName( final @PathVariable("summonerName")String summonerName) {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.4/summoner/by-name" ).Path( summonerName ).Build();
        return restTemplateBean.exchange( url, SummonerDto.class );
    }
}
