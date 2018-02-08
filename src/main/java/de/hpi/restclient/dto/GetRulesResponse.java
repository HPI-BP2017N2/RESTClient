package de.hpi.restclient.dto;

import de.hpi.restclient.pojo.ExtractedDataMap;
import de.hpi.restclient.pojo.Rules;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetRulesResponse {

    private Rules rules;
}
