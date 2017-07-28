package com.venzee.model;

public class DataQueueUrl {

    private String pushContextId;
    private String cacheControl;
    private boolean enableQueue;
    private String password;
    private String workerAddress;

    public String getPushContextId() {
        return pushContextId;
    }

    public void setPushContextId(String pushContextId) {
        this.pushContextId = pushContextId;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public boolean isEnableQueue() {
        return enableQueue;
    }

    public void setEnableQueue(boolean enableQueue) {
        this.enableQueue = enableQueue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress;
    }
}
