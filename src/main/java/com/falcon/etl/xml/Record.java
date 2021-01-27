package com.falcon.etl.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class Record {
    private String gender;

    private String first_name;

    private String email;

    @XmlElement(name = "gender")
    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    @XmlElement(name = "first_name")
    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    @XmlElement(name = "email")
    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gender = "+gender+", first_name = "+first_name+", email = "+email+"]";
    }
}