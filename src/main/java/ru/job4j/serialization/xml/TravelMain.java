package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TravelMain {
    public static void main(String[] args) throws JAXBException, IOException {
        Travel travel = new Travel(true, 130000, "Anex", new Country("Egypt"),
                new String[]{"Kleopatra", "5-star"});
        JAXBContext context = JAXBContext.newInstance(Travel.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(travel, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Travel rsl = (Travel) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }
    }
}