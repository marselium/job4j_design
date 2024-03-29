package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public class Country {

    @XmlAttribute
    private String name;

    public Country() {

        name = null;
    }

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{"
                + "name='" + name  + '\''
                + '}';
    }
}
