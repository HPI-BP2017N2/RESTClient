package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Rules {

    private HashMap<OfferAttribute, Rule> rules;
}
