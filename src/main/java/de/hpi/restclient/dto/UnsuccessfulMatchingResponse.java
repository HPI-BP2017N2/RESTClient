package de.hpi.restclient.dto;

public class UnsuccessfulMatchingResponse extends MatchingResponse {

    public UnsuccessfulMatchingResponse(Number shopId, String url, String parsedCategory){
        setIdealoOffer(false);
        setShopId(shopId);
        setParsedCategory(parsedCategory);
        setUrl(url);
    }
}
