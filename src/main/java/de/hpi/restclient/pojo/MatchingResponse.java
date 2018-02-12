package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MatchingResponse {

    private Number shopId, offerId;
    private String parsedCategory, idealoCategory, url;
    private boolean isIdealoOffer;

    // initialization
    public MatchingResponse(){}

}
