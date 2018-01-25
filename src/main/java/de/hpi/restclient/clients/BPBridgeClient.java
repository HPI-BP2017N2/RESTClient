package de.hpi.restclient.clients;

import de.hpi.restclient.dto.GetRandomOffersResponse;
import de.hpi.restclient.dto.MatchAttributeResponse;
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

    public GetRandomOffersResponse getRandomOffer(long shopID, int maxCount) {
        return getRestTemplate().getForObject(getGetRandomOffersURI(shopID, maxCount), GetRandomOffersResponse.class);
    }

    public GetRandomOffersResponse getRandomOffer(long shopID, int maxCount, int offset) {
        return getRestTemplate().getForObject(getGetRandomOffersURI(shopID, maxCount, offset), GetRandomOffersResponse
                .class);
    }

    public MatchAttributeResponse matchAttribute(long shopID, String searchAttribute, String attributeValue) {
        return getRestTemplate().getForObject(matchAttributeURI(shopID, searchAttribute, attributeValue ),
                MatchAttributeResponse.class);
    }

    private URI getShopIDToUrlURI(long shopID) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getShopIDToURLRoute())
                .queryParam("shopID", shopID)
                .build()
                .encode()
                .toUri();
    }

    private URI getGetRandomOffersURI(long shopID, int maxCount) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getGetRandomOfferRoute())
                .queryParam("shopID", shopID)
                .queryParam("count", maxCount)
                .build()
                .encode()
                .toUri();
    }

    private URI getGetRandomOffersURI(long shopID, int maxCount, int offset) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getGetRandomOfferRoute())
                .queryParam("shopID", shopID)
                .queryParam("count", maxCount)
                .queryParam("offset", offset)
                .build()
                .encode()
                .toUri();
    }

    private URI matchAttributeURI(long shopID, String searchAttribute, String attributeValue) {
        return UriComponentsBuilder.fromUriString(getProperties().getRoot())
                .path(getProperties().getMatchAttributeRoute())
                .queryParam("shopID",shopID)
                .queryParam("searchAttribute",searchAttribute)
                .queryParam("attributeValue",attributeValue)
                .build()
                .encode()
                .toUri();
    }
}
