package de.hpi.restclient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class Offer {

    private List<String> categoryPaths;
    private Map<String, Number> price;
    private Map<String, String> description, offerTitle, url;
    private Number shopId;
    private String currency, sku, han, brandSearchtext, categoryString, ean, attrSearchtext, productSearchtext;

     /*
        Java reflection is used and indicates possible bad code style, but ensures code flexibility.
        Reconsider this code snippet maybe.
     */

    @JsonIgnore
    public EnumMap<OfferAttribute, String> getOfferSnapshot() throws NoSuchFieldException, IllegalAccessException {
        EnumMap<OfferAttribute, String> snapshot = new EnumMap<>(OfferAttribute.class);
        for (OfferAttribute offerAttribute : OfferAttribute.values()) {
            Field offerAttributeField = getClass().getDeclaredField(convertOfferAttributeToFieldName(offerAttribute));
            offerAttributeField.setAccessible(true);
            snapshot.put(offerAttribute, getValue(offerAttributeField.get(this)));
        }
        return snapshot;
    }

    /**
     * @param object The object that needs to be converted to a string representation.
     * @return String representation for the given object. If the object is a list or a map, the first value gets
     * returned.
     */
    @JsonIgnore
    private String getValue(Object object) {
        if (object instanceof Map) {
            Map map = (Map) object;
            if (!map.isEmpty()) { return map.values().iterator().next().toString(); }
        } else if (object instanceof List) {
            List list = (List) object;
            if (!list.isEmpty()) { return list.get(0).toString(); }
        } else if (object != null) {
            return object.toString();
        }
        return null;
    }

    //conversion
    private String convertOfferAttributeToFieldName(OfferAttribute offerAttribute) {
        StringBuilder fieldName = new StringBuilder(offerAttribute.toString().toLowerCase());
        int underscoreIndex = -1;
        while ((underscoreIndex = fieldName.indexOf("_")) != -1) {
            fieldName.deleteCharAt(underscoreIndex);
            if (underscoreIndex < fieldName.length()) {
                fieldName.setCharAt(underscoreIndex, Character.toUpperCase(fieldName.charAt(underscoreIndex)));
            }
        }
        return fieldName.toString();
    }
}
