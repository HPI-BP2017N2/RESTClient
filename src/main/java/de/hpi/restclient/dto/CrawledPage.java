package de.hpi.restclient.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrawledPage {
    private long shopID;
    private long timestamp;
    private String url;
    private String htmlSource;

    @JsonCreator
    public CrawledPage(@JsonProperty("shopId") long shopId,
                       @JsonProperty("timestamp") long timestamp,
                       @JsonProperty("url") String url,
                       @JsonProperty("htmlSource") String htmlSource){
        setShopID(shopId);
        setTimestamp(timestamp);
        setUrl(url);
        setHtmlSource(htmlSource);
    }
}
