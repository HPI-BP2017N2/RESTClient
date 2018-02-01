package de.hpi.restclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MatchingResponse {

    private Number shopId, offerId;
    private String parsedCategory, idealoCategory;
    private boolean isIdealoOffer;

    // initialization
    public MatchingResponse(Number shopId, String parsedCategory){
        self().setIdealoOffer(false);
        self().setShopId(shopId);
        self().setParsedCategory(parsedCategory);
    }

    public MatchingResponse(Number shopId, Number offerId, String parsedCategory, String idealoCategory){
        self().setIdealoOffer(true);
        self().setShopId(shopId);
        self().setOfferId(offerId);
        self().setParsedCategory(parsedCategory);
        self().setIdealoCategory(idealoCategory);
    }

    private MatchingResponse self(){
        return this;
    }
}
