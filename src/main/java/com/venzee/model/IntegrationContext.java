package com.venzee.model;

/**
 * Created by antoniohernandez on 7/26/17.
 */
public class IntegrationContext {

    private Platform shopify;
    private Platform woo;

    public IntegrationContext() {}

    public IntegrationContext(Platform shopify, Platform woo) {
        setShopify(shopify);
        setWoo(woo);
    }

    public IntegrationContext(Platform shopify) {
        this(shopify, null);
    }

    public Platform getShopify() {
        return shopify;
    }

    public void setShopify(Platform shopify) {
        this.shopify = shopify;
    }

    public Platform getWoo() {
        return woo;
    }

    public void setWoo(Platform woo) {
        this.woo = woo;
    }
}
