package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RuleEntry {

    private boolean resultAsPlainText;
    private String attribute, selector;

}
