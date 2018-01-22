package de.hpi.restclient.dto;

import de.hpi.restclient.pojo.Offer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GetRandomOffersResponse {

    private List<Offer> offers;

}
