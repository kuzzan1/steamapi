package main.java.steam.bean;;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBean implements FactoryBean<RestTemplate>, InitializingBean {
    private RestTemplate restTemplate;

    @Override
    public RestTemplate getObject() throws Exception {
        return restTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        HttpHost host = new HttpHost("localhost", 8080, "http");
        restTemplate = new RestTemplate(
                new HttpComponentsClientHttpRequestFactoryBasicAuth(host));
    }

    public String exchange(String url) {
        String body = "";
        try {
            body = getObject().exchange(url, HttpMethod.GET, null, String.class).getBody();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return body;
    }
}
