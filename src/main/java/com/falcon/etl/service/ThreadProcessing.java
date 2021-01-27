package com.falcon.etl.service;

import com.falcon.etl.repository.RepositoryUtiility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ThreadProcessing {

    @Autowired
    RepositoryUtiility repositoryUtiility;

    public void process(Map<Integer, List<String>> fileMap) {
        parallelProcess(fileMap.get(1));
        parallelProcess(fileMap.get(2));

    }

    public void parallelProcess(List<String> fileList) {

        // create threadPool
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Future> allFutures = new ArrayList<>();

        // submit the tasks for execution
        for (String file : fileList) {
            Future<String> future = service.submit(new DbLoad(file, repositoryUtiility));
            allFutures.add(future);
        }
        for (Future future : allFutures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
