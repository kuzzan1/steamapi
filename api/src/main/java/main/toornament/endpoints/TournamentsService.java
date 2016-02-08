package main.toornament.endpoints;

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

    @RequestMapping("/app/tournaments")
    public Tournament[] getTournaments() throws Exception{
        String url = URL + ApiKey.getKey() + "&discipline=counterstrike_go&featured=1&sort=date_desc";
        System.out.println(url);
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Tournament[].class ).getBody();
    }

    @RequestMapping("/app/tournaments/{id}")
    public Tournament getTournaments( @PathVariable( "id" ) final String id ) {
        String url = URL +"/" + id + ApiKey.getKey();
        System.out.println(url);
        return restTemplateBean.exchange( url, Tournament.class );
    }

}
