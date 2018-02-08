package de.hpi.restclient.clients;

import de.hpi.restclient.dto.MatchAttributeResponse;
import de.hpi.restclient.pojo.ExtractedDataMap;
import de.hpi.restclient.pojo.Rules;
import de.hpi.restclient.properties.BPBridgeProperties;
import de.hpi.restclient.properties.ShopRulesGeneratorProperties;
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
public class ShopRulesGeneratorClient {

    private ShopRulesGeneratorProperties properties;
    private RestTemplate restTemplate;

    public ShopRulesGeneratorClient(ShopRulesGeneratorProperties properties, RestTemplateBuilder restTemplateBuilder) {
        setProperties(properties);
        setRestTemplate(restTemplateBuilder.build());
    }

    public void getRules(long shopID, String responseRoot, String responsePath) {
        getRestTemplate().getForObject(getRulesURI(shopID, responseRoot, responsePath), String.class);
    }

    private URI getRulesURI(long shopID, String responseRoot, String responsePath) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getGetRulesRoute())
                .queryParam("shopID", shopID)
                .queryParam("responseRoot", responseRoot)
                .queryParam("responsePath", responsePath)
                .build()
                .encode()
                .toUri();
    }
}
