package com.venzee.enumerations;

/**
 * Created by antoniohernandez on 7/28/17.
 */
public enum PlatformType {

    SHOPIFY, WOO;

    public String getJSONTag() {

        switch (this) {
            //Change woo return value to be coherent with the tag used on the JSON response, if needed.
            case WOO:
                return "woo";
            case SHOPIFY:
                return "shopify";
            default:
                return "shopify";
        }
    }


}
