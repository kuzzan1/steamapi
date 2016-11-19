package main.riot.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
@RestController
public class StatusDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/status")
    public List getStatusData() {
        String url = new URLBuilder().baseUrl("http://status.leagueoflegends.com/shards").buildRiot();
        return restTemplateBean.exchange(url, ArrayList.class);
    }
}
