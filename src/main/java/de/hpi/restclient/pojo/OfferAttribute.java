package de.hpi.restclient.pojo;

/*
    This enum has a specific naming convention.
    The name of the offer attribute is converted into capitalized letters.
    Each camel case is converted to a underscore.
    Example: attrSearchtext (from the Idealo DB and the Offer POJO)
    Becomes: ATTR_SEARCHTEXT
 */

public enum OfferAttribute {
    ATTR_SEARCHTEXT,
    BRAND_SEARCHTEXT,
    CATEGORY_PATHS,
    CATEGORY_STRING,
    CURRENCY,
    DESCRIPTION,
    EAN,
    HAN,
    OFFER_TITLE,
    PRICE,
    PRODUCT_SEARCHTEXT,
    SHOP_ID,
    SKU,
    URL
}
