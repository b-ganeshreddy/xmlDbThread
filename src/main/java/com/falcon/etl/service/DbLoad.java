package com.falcon.etl.service;

import com.falcon.etl.entity.User;
import com.falcon.etl.repository.RepositoryUtiility;
import com.falcon.etl.util.Utility;
import com.falcon.etl.xml.Dataset;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

public class DbLoad implements Callable<String> {

    private String fileName;
    private RepositoryUtiility repositoryUtiility;

    public DbLoad(String fileName, RepositoryUtiility repositoryUtiility) {
        this.fileName = fileName;
        this.repositoryUtiility = repositoryUtiility;
    }

    @Override
    public String call() throws Exception {
        try {
            Utility utility = new Utility();
            Dataset dataset = utility.unmarshal(this.fileName);
            List<User> records = utility.xmlToDb(dataset);
            repositoryUtiility.saveToDbList(records);
            System.out.println("Current thread - " + Thread.currentThread());
            return "Successfully processed";
        } catch (Exception e) {
            return "Failed in call method of DbLoad.";
        }
    }

}
