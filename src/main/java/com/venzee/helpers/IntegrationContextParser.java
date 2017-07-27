package com.venzee.helpers;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.venzee.model.IntegrationContext;
import com.venzee.model.Push;
import com.venzee.model.Shopify;
import com.venzee.model.TotalsRunning;
import net.minidev.json.JSONArray;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by antoniohernandez on 7/27/17.
 */
public class IntegrationContextParser {

    private IntegrationContextParser() {}

    public static IntegrationContext parseContext(InputStream response) {
        IntegrationContext context = new IntegrationContext();
        Shopify shopify = new Shopify();
        TotalsRunning totals;
        ReadContext ctx = JsonPath.parse(response);
        Map<String, Object> activeIntegrations = ctx.read("activeIntegrations");
        Map<String, Object> pushesCurrentlyRunning = ctx.read("pushesCurrentlyRunning");
        Map<String, Object> totalsRunningByPlatform = ctx.read("totalsRunningByPlatform");
        totals = new TotalsRunning((Map<String, Object>) totalsRunningByPlatform.get("shopify"));

        JSONArray pushes = ctx.read("pushesRunning");
        List<Push> pushList = pushes
                .stream()
                .map(push -> new Push((Map<String, Object>)push))
                .collect(Collectors.toList());
        shopify.setPushesRunning(pushList);
        shopify.setTotalsRunning(totals);
        shopify.setPushesCurrentlyRunning((int)pushesCurrentlyRunning.get("shopify"));
        shopify.setActiveIntegrations((int)activeIntegrations.get("shopify"));
        context.setShopify(shopify);
        System.out.println(shopify.getTotalsRunning().getTotalProducts());
        return  context;
    }
}
