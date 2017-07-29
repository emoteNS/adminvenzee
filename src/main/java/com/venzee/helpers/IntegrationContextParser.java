package com.venzee.helpers;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.venzee.enumerations.PlatformType;
import com.venzee.model.*;
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

        return new IntegrationContext(getPlatform(response, PlatformType.SHOPIFY));
    }


    private static List<Push> parseRunningPushes(ReadContext context, PlatformType type) {
        JSONArray pushes = context.read("pushesRunning");
        return pushes
                .stream()
                .map(push -> new Push((Map<String, Object>)push))
                .filter(push -> push.getPlatform() != type.getJSONTag())
                .collect(Collectors.toList());
    }

    private static TotalsRunning parseTotals(ReadContext context , PlatformType type) {
        Map<String, Object> totalsRunningByPlatform = context.read("totalsRunningByPlatform");
        TotalsRunning totalsRunning = new TotalsRunning((Map<String, Object>) totalsRunningByPlatform.get(type.getJSONTag()));
        return totalsRunning != null ? totalsRunning : null;
    }

    private static int parsePushesCurrentlyRunning(ReadContext context, PlatformType type) {
        Map<String, Object> pushesCurrentlyRunning = context.read("pushesCurrentlyRunning");
        return (int)pushesCurrentlyRunning.get(type.getJSONTag());
    }

    private static int parseActiveIntegrations(ReadContext context, PlatformType type) {
        Map<String, Object> activeIntegrations = context.read("activeIntegrations");
        return (int)activeIntegrations.get(type.getJSONTag());
    }

    private static Platform getPlatform(InputStream response, PlatformType type) {
        ReadContext ctx = JsonPath.parse(response);
        return new Platform(parseActiveIntegrations(ctx, type),
                            parsePushesCurrentlyRunning(ctx, type),
                            parseTotals(ctx, type),
                            parseRunningPushes(ctx, type));
    }

}
