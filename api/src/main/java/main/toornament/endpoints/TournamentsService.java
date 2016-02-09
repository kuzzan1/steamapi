package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Tournament;
import main.toornament.security.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-01-19.
 */
@RestController
public class TournamentsService {

    @Autowired
    private RestTemplateBean restTemplateBean;

    private String URL = "https://api.toornament.com/v1/tournaments";

    @RequestMapping("/app/tournaments/cs")
    public Tournament[] getCSGO() throws Exception{
        String url = new URLBuilder().baseUrl(URL).Param("api_key", ApiKey.getKey()).Param("discipline", "counterstrike_go").Param("featured", "1").Param("sort", "date_desc").Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Tournament[].class ).getBody();
    }

    @RequestMapping("/app/tournaments/{tournamentId}")
    public Tournament getTournamentInfo(@PathVariable( "tournamentId" ) final String tournamentId ) {
        String url = new URLBuilder().baseUrl(URL+"/"+tournamentId).Param("api_key", ApiKey.getKey()).Build();
        return restTemplateBean.exchange( url, Tournament.class );
    }

    @RequestMapping("/app/tournaments/sport/{sportId}")
    public Tournament[] getTournaments(@PathVariable( "id" ) final String sportId ) throws Exception {
        String url = new URLBuilder().baseUrl(URL).Param("api_key", ApiKey.getKey()).Param("discipline", sportId).Param("featured", "1").Param("sort", "date_desc").Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Tournament[].class ).getBody();
    }
}
