package main.steam.bean;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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
        HttpHost host = new HttpHost( "localhost", 8080, "http" );
        restTemplate = new RestTemplate(
                new HttpComponentsClientHttpRequestFactoryBasicAuth( host ) );
    }

    public String exchange( String url ) {
        return exchange( url, null, String.class, HttpMethod.GET );
    }

    public <T> T exchange( String url, Class<T> clazz ) {
        return exchange( url, null, clazz, HttpMethod.GET );
    }

    public <T> T exchange( String url, HttpEntity<String> entity, Class<T> clazz, HttpMethod httpMethod ) {
        System.out.println("Call: " + url );
        T body = null;
        try {
            body = clazz.newInstance();
        } catch ( InstantiationException | IllegalArgumentException | IllegalAccessException e ) {
            System.out.println( "Cant create new instance" );

        }

        try {
            ResponseEntity<T> exchange = getObject().exchange( url, httpMethod, entity, clazz );
            System.out.println("X-Rate-Limit-Count" + exchange.getHeaders().get("X-Rate-Limit-Count"));
            body = exchange.getBody();

        } catch ( Exception e ) {
            if(e instanceof HttpClientErrorException) {
                HttpHeaders responseHeaders = ((HttpClientErrorException) e).getResponseHeaders();
                System.out.println(e.getMessage() + ": " + responseHeaders.get("X-Rate-Limit-Count"));
            } else {
                System.out.println( e.getMessage());
            }
        }
        return body;
    }

}
