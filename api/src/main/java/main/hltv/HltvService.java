package main.hltv;

import main.hltv.domain.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.steam.bean.RestTemplateBean;

/**
 * Created by jonas on 2016-01-18.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class HltvService {

    @Autowired
    private RestTemplateBean restTemplateBean;

    private String URL = "http://www.hltv.org/hltv.rss.php";

    @RequestMapping(name = "/app/cs/upcomming",  produces = "application/json")
    public Rss getUpComingCSGOMatches() {
        Rss exchange = restTemplateBean.exchange(URL + "?pri=15", Rss.class);
        return exchange;
    }


}
