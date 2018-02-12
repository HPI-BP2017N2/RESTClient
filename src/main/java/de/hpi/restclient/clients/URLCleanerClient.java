package de.hpi.restclient.clients;

import de.hpi.restclient.dto.CleanURLResponse;
import de.hpi.restclient.dto.ShopIDToUrlResponse;
import de.hpi.restclient.properties.BPBridgeProperties;
import de.hpi.restclient.properties.URLCleanerProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE)
public class URLCleanerClient {

    private URLCleanerProperties properties;
    private RestTemplate restTemplate;

    public URLCleanerClient(URLCleanerProperties properties, RestTemplateBuilder restTemplateBuilder) {
        setProperties(properties);
        setRestTemplate(restTemplateBuilder.build());
    }

    public CleanURLResponse cleanURL(String url, long shopID) {
        return getRestTemplate().getForObject(getCleanURLURI(url, shopID), CleanURLResponse.class);
    }

    private URI getCleanURLURI(String url, long shopID) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getCleanURLRoute())
                .queryParam("url", url)
                .queryParam("shopID", shopID)
                .build()
                .encode()
                .toUri();
    }
}
