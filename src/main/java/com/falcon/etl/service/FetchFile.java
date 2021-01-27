package com.falcon.etl.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FetchFile {

    public Map<Integer, List<String>> getTemporaryFileList() {
        Map<Integer, List<String>> fileMap = new HashMap<>();

        List<String> vendorFiles = new ArrayList<>();
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");
        vendorFiles.add("/Users/ganesh/dataset.xml");

        List<String> invoiceFiles = new ArrayList<>();
        invoiceFiles.add("/Users/ganesh/dataset.xml");

        fileMap.put(1, vendorFiles);
        fileMap.put(2, invoiceFiles);

        return fileMap;
    }

}
