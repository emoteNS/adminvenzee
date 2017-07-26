package com.venzee.model;

import java.time.LocalDateTime;

/**
 * Created by antoniohernandez on 7/26/17.
 */
public class Pushes {

    private String platform;
    private String organizationName;
    private String collectionId;
    private String integrationContextID;
    private int totalProducts;
    private int processedProducts;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getIntegrationContextID() {
        return integrationContextID;
    }

    public void setIntegrationContextID(String integrationContextID) {
        this.integrationContextID = integrationContextID;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getProcessedProducts() {
        return processedProducts;
    }

    public void setProcessedProducts(int processedProducts) {
        this.processedProducts = processedProducts;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
