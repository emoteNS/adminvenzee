package com.venzee.service;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.venzee.helpers.IntegrationContextParser;
import com.venzee.model.IntegrationContext;
import com.venzee.model.Push;
import com.venzee.model.Shopify;
import com.venzee.model.TotalsRunning;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;
import okhttp3.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by antoniohernandez on 7/26/17.
 */
@Component
public class IntegrationContextService {

    private static String qaURLString;
    private static String prodURLString;
    private final OkHttpClient.Builder _builder = new OkHttpClient.Builder();

    static {
        //TODO: use a yml specific library to retrieve properties this.
        Properties props = new Properties();
        try {
            props.load(IntegrationContextService.class.getResourceAsStream("/application.yml"));
            qaURLString = props.getProperty("qaUri");
            prodURLString = props.getProperty("prodUri");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Request buildRequestForContext(String urlString) {
        final Request.Builder builder = new Request.Builder();
        builder.url(urlString);
        builder.get();
        return builder.build();
    }
    private OkHttpClient createHttpClient() {
        if (_builder.interceptors().isEmpty()) {
            _builder.connectTimeout(2, TimeUnit.MINUTES);
            _builder.readTimeout(2, TimeUnit.MINUTES);
        }
        return _builder.build();
    }
    public InputStream sendRequest(Request request) throws IOException {
        final Response response = createHttpClient().newCall(request).execute();
        return response.body().byteStream();
    }

    public IntegrationContext parseContextResponse(InputStream response) {
        return IntegrationContextParser.parseContext(response);
    }



    public IntegrationContext getIntegrationContext() throws IOException {

        Request request = buildRequestForContext(prodURLString);
        InputStream response = sendRequest(request);
        return parseContextResponse(response);

    }

    public static void main(String args[]) {
        IntegrationContextService service = new IntegrationContextService();
        try {
            System.out.println(service.getIntegrationContext());
        } catch (IOException e ) {


        }

    }
    public IntegrationContext retrieveContext() {return null;}
}
