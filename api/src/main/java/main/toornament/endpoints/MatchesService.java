package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Match;
import main.helper.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blagan on 2016-01-23.
 */
@RestController
public class MatchesService {
    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.toornament.com/v1/tournaments/";

    @RequestMapping("/app/{tournamentId}/matches")
    public Match[] getMatchesInTournament(@PathVariable("tournamentId") final String tournamentId) throws Exception {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("matches").Param("api_key", ApiKey.getToornamentKey()).Param( "with_games", "1").Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Match[].class ).getBody();
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}")
    public Match getInformationOnMatch(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("matches").Path(matchId).Param("api_key", ApiKey.getToornamentKey()).Param( "with_games", "1").Build();
        return restTemplateBean.exchange(url ,Match.class);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}/result")
    public String getMatchResults(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("matches").Path(matchId).Path("result").Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url );
    }

}
