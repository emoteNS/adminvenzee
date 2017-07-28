package com.venzee.service;

import com.venzee.model.DataQueueUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkerRequestService {

    private static Logger workerLogger = LoggerFactory.getLogger(WorkerRequestService.class);

    public String requestWorkerAction(DataQueueUrl data, String uri){

        RestTemplate template = new RestTemplate();

        HttpEntity<String> entity = buildHeadersEntityWithDQU(data);

        uri += data.getCacheControl();

        ResponseEntity<String> response = template.exchange(uri, HttpMethod.GET, entity, String.class);

        workerLogger.info("Requesting object from uri: {}", uri);

        return response.getBody().toString();
    }

    public HttpEntity<String> buildHeadersEntityWithDQU(DataQueueUrl data){
        HttpHeaders headers = new HttpHeaders();

        headers.add("cache-control", data.getCacheControl());
        headers.add("enablequeue", data.isEnableQueue() + "");
        headers.add("password", data.getPassword());
        headers.add("workeraddress", data.getWorkerAddress());

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return entity;
    }
}
