package com.venzee.model;

import java.util.List;

/**
 * Created by antoniohernandez on 7/26/17.
 */
public class Shopify {

    private int activeIntegrations;
    private int pushesCurrentlyRunning;
    private TotalsRunning totalsRunning;
    private List<Pushes> pushesRunning;

    public int getActiveIntegrations() {
        return activeIntegrations;
    }

    public void setActiveIntegrations(int activeIntegrations) {
        this.activeIntegrations = activeIntegrations;
    }

    public int getPushesCurrentlyRunning() {
        return pushesCurrentlyRunning;
    }

    public void setPushesCurrentlyRunning(int pushesCurrentlyRunning) {
        this.pushesCurrentlyRunning = pushesCurrentlyRunning;
    }

    public TotalsRunning getTotalsRunning() {
        return totalsRunning;
    }

    public void setTotalsRunning(TotalsRunning totalsRunning) {
        this.totalsRunning = totalsRunning;
    }

    public List<Pushes> getPushesRunning() {
        return pushesRunning;
    }

    public void setPushesRunning(List<Pushes> pushesRunning) {
        this.pushesRunning = pushesRunning;
    }
}
