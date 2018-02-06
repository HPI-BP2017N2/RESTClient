package de.hpi.restclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MatchingResponse {

    private Number shopId, offerId;
    private String parsedCategory, idealoCategory, url;
    private boolean isIdealoOffer;

    // initialization
    public MatchingResponse(){}

    public MatchingResponse(Number shopId, String url, String parsedCategory){
        self().setIdealoOffer(false);
        self().setShopId(shopId);
        self().setParsedCategory(parsedCategory);
        self().setUrl(url);
    }

    public MatchingResponse(Number shopId, String url, Number offerId, String parsedCategory, String idealoCategory){
        self().setIdealoOffer(true);
        self().setShopId(shopId);
        self().setOfferId(offerId);
        self().setParsedCategory(parsedCategory);
        self().setIdealoCategory(idealoCategory);
        self().setUrl(url);
    }

    private MatchingResponse self(){
        return this;
    }
}
