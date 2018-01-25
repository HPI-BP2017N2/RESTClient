package de.hpi.restclient.pojo;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
class OfferTest {

    private Offer offer;

    @BeforeEach
    public void setUp() {
        Offer offer = new Offer();
        offer.setAttrSearchtext("attr");
        HashMap<String, String> description = new HashMap<>();
        description.put("0", "Hello");
        description.put("1", "World");
        offer.setDescription(description);
        offer.setCategoryPaths(Arrays.asList("Category1", "Category2"));
        setOffer(offer);
    }

    @Test
    void getOfferSnapshot() throws NoSuchFieldException, IllegalAccessException {
        EnumMap<OfferAttribute, String> snapshot = getOffer().getOfferSnapshot();
        assertEquals(snapshot.get(OfferAttribute.ATTR_SEARCHTEXT), "attr");
        assertEquals(snapshot.get(OfferAttribute.DESCRIPTION), "Hello");
        assertEquals(snapshot.get(OfferAttribute.CATEGORY_PATHS), "Category1");
    }
}