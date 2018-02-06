package de.hpi.restclient.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;

@Getter
@Setter
public class ExtractedDataMap {

    private EnumMap<OfferAttribute, ExtractedDataEntry> data;
}
