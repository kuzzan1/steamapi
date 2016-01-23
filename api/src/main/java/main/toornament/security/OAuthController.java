package main.toornament.security;

import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Oauth2;
import main.toornament.domain.PostOauth2;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * Created by jonas on 2016-01-19.
 */
@Component
public class OAuthController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    private String URL = "https://api.toornament.com/oauth/v2/token";

    private Oauth2 oauth2;
    public Oauth2 getOauth2Token() {
        if(oauth2 == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType( MediaType.APPLICATION_JSON);
            PostOauth2 postOauth2 = new PostOauth2();
            JSONObject postData = new JSONObject();
            postData.put("client_id", postOauth2.getClient_id());
            postData.put("client_secret", postOauth2.getClient_secret());
            postData.put("grant_type", postOauth2.getGrant_type());

            HttpEntity<String> entity = new HttpEntity<String>(postData.toString(), headers);
            Oauth2 exchange = restTemplateBean.exchange(URL, entity, Oauth2.class, HttpMethod.POST);
            return exchange;
        }

        return oauth2;
    }



}
