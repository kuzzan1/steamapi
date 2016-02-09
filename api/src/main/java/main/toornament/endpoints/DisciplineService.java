package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Discipline;
import main.toornament.security.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String url = new URLBuilder().baseUrl(URL).Param("api_key", ApiKey.getKey()).Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Discipline[].class ).getBody();
    }
}
