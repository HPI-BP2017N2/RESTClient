package de.hpi.restclient.pojo;

public class SuccessfulMatchingResponse extends MatchingResponse {

    public SuccessfulMatchingResponse(Number shopId, String url, Number offerId, String parsedCategory, String idealoCategory){
        setIdealoOffer(true);
        setShopId(shopId);
        setOfferId(offerId);
        setParsedCategory(parsedCategory);
        setIdealoCategory(idealoCategory);
        setUrl(url);
    }
}
