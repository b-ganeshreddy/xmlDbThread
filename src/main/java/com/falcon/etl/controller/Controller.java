package com.falcon.etl.controller;

import com.falcon.etl.service.FetchFile;
import com.falcon.etl.service.ThreadProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private ThreadProcessing threadProcessing;

    @Autowired
    private FetchFile fetchFile;

    @GetMapping("/health")
    public String health() {
        logger.info("Health Controller hitting.");
        return "Health is OK.";
    }

    @GetMapping("/load")
    public void doLoad() {
        logger.info("dbLoad Controller Starting.");
        threadProcessing.process(fetchFile.getTemporaryFileList());
        logger.info("dbLoad Controller Ended.");
    }
}
