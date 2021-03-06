package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.helper.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blagan on 2016-01-23.
 */
@RestController
public class ScheduleService {
    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.toornament.com/v1/tournaments/";

    @RequestMapping("/app/{tournamentId}/schedule")
    public String getPlayersInTournament(@PathVariable("tournamentId") final String tournamentId) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("schedules").Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url );
    }

}

