package com.falcon.etl.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dataset")
public class Dataset {
    private List<Record> record;

    @XmlElement(name = "record")
    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "record=" + record +
                '}';
    }
}