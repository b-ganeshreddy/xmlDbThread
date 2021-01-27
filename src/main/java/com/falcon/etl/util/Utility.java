package com.falcon.etl.util;

import com.falcon.etl.entity.User;
import com.falcon.etl.xml.Dataset;
import com.falcon.etl.xml.Record;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Utility {

    // Dataset
    public List<User> xmlToDb(Dataset dataset) {
        List<Record> x = dataset.getRecord();
        List<User> users = new ArrayList<>();
        for (Record record : x) {
            User user = new User();
            user.setName(record.getFirst_name());
            user.setGender(record.getGender());
            user.setEmail(record.getEmail());
            users.add(user);
        }
        return users;
    }

    public Dataset unmarshal(String fileName) throws JAXBException {
        File file = new File(fileName);
        System.out.println("Current Thread - " + Thread.currentThread().getName());
        JAXBContext context = JAXBContext.newInstance(Dataset.class);
        Unmarshaller un = context.createUnmarshaller();
        Dataset dataset = (Dataset) un.unmarshal(file);
        return dataset;
    }
}
