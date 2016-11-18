package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Discipline;
import main.helper.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-02-09.
 */
@RestController
public class DisciplineService {
    private String URL = "https://api.toornament.com/v1/disciplines";

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/sport")
    public Discipline[] getDisciplines() throws Exception {
        String url = new URLBuilder().baseUrl(URL).Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Discipline[].class ).getBody();
    }

    public Discipline getDiscipline( String discipline ) throws Exception {
        String url = new URLBuilder().baseUrl(URL).Path(discipline).Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Discipline.class ).getBody();
    }


    @RequestMapping("/app/matches/discipline/{disciplineId}")
    public String getMatchesPerDiscipline(
            @PathVariable("disciplineId") final String disciplineId,
            @RequestParam(required = false) final String page,
            @RequestParam(required = false) final Integer withGames,
            @RequestParam(required = false) final Integer results,
            @RequestParam(required = false) final Integer featured) throws Exception {

        String url = new URLBuilder().baseUrl(URL).Path(disciplineId).Path( "matches" ).Param( "featured", featured ). Param( "page", page ). Param( "with_games", withGames ).Param( "has_result", results ).Param("api_key", ApiKey.getToornamentKey()).Build();
        System.out.println(url);
        return  restTemplateBean.exchange(url );
    }

}
