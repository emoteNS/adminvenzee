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
        IntegrationContext integrationContext = new IntegrationContext();
        Shopify shopify = new Shopify();
        ReadContext ctx = JsonPath.parse(response);
        shopify.setPushesRunning(parseRunningPushes(ctx));
        shopify.setTotalsRunning(parseTotals(ctx));
        shopify.setPushesCurrentlyRunning(parsePushesCurrentlyRunning(ctx));
        shopify.setActiveIntegrations(parseActiveIntegrations(ctx));
        integrationContext.setShopify(shopify);
        return  integrationContext;
    }

    private static Shopify parseShopify() {
        Shopify shopify = new Shopify();
        return shopify;
    }

    private static List<Push> parseRunningPushes(ReadContext context) {
        JSONArray pushes = context.read("pushesRunning");
        return pushes
                .stream()
                .map(push -> new Push((Map<String, Object>)push))
                .filter(push -> push.getPlatform() != "shopify")
                .collect(Collectors.toList());
    }

    private static TotalsRunning parseTotals(ReadContext context) {
        Map<String, Object> totalsRunningByPlatform = context.read("totalsRunningByPlatform");
        return new TotalsRunning((Map<String, Object>) totalsRunningByPlatform.get("shopify"));
    }

    private static int parsePushesCurrentlyRunning(ReadContext context) {
        Map<String, Object> pushesCurrentlyRunning = context.read("pushesCurrentlyRunning");
        return (int)pushesCurrentlyRunning.get("shopify");
    }

    private static int parseActiveIntegrations(ReadContext context) {
        Map<String, Object> activeIntegrations = context.read("activeIntegrations");
        return (int)activeIntegrations.get("shopify");
    }
}
