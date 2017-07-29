package com.venzee.model;

import java.util.List;

/**
 * Created by antoniohernandez on 7/28/17.
 */
public class Platform {

    protected int activeIntegrations;
    protected int pushesCurrentlyRunning;
    protected TotalsRunning totalsRunning;
    protected List<Push> pushesRunning;

    public Platform (int activeIntegrations, int pushesCurrentlyRunning, TotalsRunning totals, List<Push> pushes) {
        setActiveIntegrations(activeIntegrations);
        setPushesCurrentlyRunning(pushesCurrentlyRunning);
        setPushesRunning(pushes);
        setTotalsRunning(totals);
    }

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

    public List<Push> getPushesRunning() {
        return pushesRunning;
    }

    public void setPushesRunning(List<Push> pushesRunning) {
        this.pushesRunning = pushesRunning;
    }

}
