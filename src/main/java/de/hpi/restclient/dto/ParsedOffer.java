package de.hpi.restclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParsedOffer {
    private long shopId;
    private String offerTitle, ean, han, sku, url, categoryString, brand;
    private double price;
}
