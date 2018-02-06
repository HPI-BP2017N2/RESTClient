package de.hpi.restclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrawledPage {
    long shopID;
    long timestamp;
    String url;
    String htmlSource;
}
