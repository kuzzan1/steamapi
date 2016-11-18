package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.stats.PlayerStatsSummaryListDto;
import main.riot.domain.stats.RankedStatsDto;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
public class StatsDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("app/lol/stats/ranked/{summonerId}")
    public RankedStatsDto getRankedStats( @PathVariable("summonerId") final int summonerId) {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.3/stats/by-summoner" ).Path( String.valueOf( summonerId ) ).Path( "ranked" ).Build();
        return restTemplateBean.exchange( url, RankedStatsDto.class );
    }

    @RequestMapping("app/lol/stats/summary/{summonerId}")
    public PlayerStatsSummaryListDto getSummaryStats( @PathVariable("summonerId") final int summonerId) {
        String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v1.3/stats/by-summoner" ).Path( String.valueOf( summonerId ) ).Path( "summary" ).Build();
        return restTemplateBean.exchange( url, PlayerStatsSummaryListDto.class );
    }
}
