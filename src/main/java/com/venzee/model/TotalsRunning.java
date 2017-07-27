package com.venzee.model;

import java.util.Map;

/**
 * Created by antoniohernandez on 7/26/17.
 */
public class TotalsRunning {

    private int processedProducts;
    private int totalProducts;

    public TotalsRunning(Map<String, Object> totalsRunningMap) {
        processedProducts = (int)totalsRunningMap.get("processedProducts");
        totalProducts = (int)totalsRunningMap.get("totalProducts");
    }

    public int getProcessedProducts() {
        return processedProducts;
    }

    public void setProcessedProducts(int processedProducts) {
        this.processedProducts = processedProducts;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }
}
