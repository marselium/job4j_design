package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name =  "travel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Travel {

    @XmlAttribute
    private boolean needVisa;

    @XmlAttribute
    private int cost;

    @XmlAttribute
    private String tourOperator;
    private Country country;

    @XmlElementWrapper(name = "hotels")
    @XmlElement(name = "hotel")
    private String[] hotel;

    public Travel() {
    }

    public Travel(boolean needVisa, int cost, String tourOperator, Country country, String[] hotel) {
        this.needVisa = needVisa;
        this.cost = cost;
        this.tourOperator = tourOperator;
        this.country = country;
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Person{"
                + "needVisa=" + needVisa
                + ", cost=" + cost
                + ", tour operator=" + tourOperator
                + ", country=" + country
                + ", hotel=" + Arrays.toString(hotel)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Travel travel = new Travel(true, 130000, "Anex", new Country("Egypt"),
                new String[]{"Kleopatra", "5-star"});
        JAXBContext context = JAXBContext.newInstance(Travel.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(travel, writer);
            String rsl = writer.getBuffer().toString();
            System.out.println(rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}