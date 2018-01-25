package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.HashMap;

@Getter @Setter
public class Rules {

    private EnumMap<OfferAttribute, Rule> rules;
}
