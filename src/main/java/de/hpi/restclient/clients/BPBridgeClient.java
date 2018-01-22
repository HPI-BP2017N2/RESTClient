package de.hpi.restclient.clients;

import de.hpi.restclient.dto.GetRandomOffersResponse;
import de.hpi.restclient.dto.ShopIDToUrlResponse;
import de.hpi.restclient.properties.BPBridgeProperties;
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
public class BPBridgeClient {

    private BPBridgeProperties properties;
    private RestTemplate restTemplate;

    public BPBridgeClient(BPBridgeProperties properties, RestTemplateBuilder restTemplateBuilder) {
        setProperties(properties);
        setRestTemplate(restTemplateBuilder.build());
    }

    public ShopIDToUrlResponse shopIDToUrl(long shopID) {
        return getRestTemplate().getForObject(getShopIDToUrlURI(shopID), ShopIDToUrlResponse.class);
    }

    public GetRandomOffersResponse getRandomOffer(long shopID) {
        return getRestTemplate().getForObject(getGetRandomOffersURI(shopID), GetRandomOffersResponse.class);
    }

    private URI getShopIDToUrlURI(long shopID) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getShopIDToURLRoute())
                .queryParam("shopID", shopID)
                .build()
                .encode()
                .toUri();
    }

    private URI getGetRandomOffersURI(long shopID) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getGetRandomOfferRoute())
                .queryParam("shopID", shopID)
                .queryParam("count", getProperties().getMaxCount())
                .build()
                .encode()
                .toUri();
    }
}
