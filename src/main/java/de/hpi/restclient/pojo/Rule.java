package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Rule {

    private List<RuleEntry> entries;
    private OfferAttribute attribute;
}
