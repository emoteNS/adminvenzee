package com.venzee.controller;

import com.venzee.model.DataQueueUrl;
import com.venzee.service.WorkerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointConsultController {

    @Value("${venzee.worker.url}")
    private String url;

    @Autowired
    WorkerRequestService workerRequestService;

    @RequestMapping("/tools")
    public String tools(DataQueueUrl data){
        return workerRequestService.requestWorkerAction(data, url);
    }
}
