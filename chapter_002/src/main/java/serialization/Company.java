package serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

    @XmlAttribute
    private boolean active;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;
    private Contact contact;

    @XmlElementWrapper(name = "founders")
    @XmlElement(name = "founder")
    private String[] founders;

    public Company() {
    }

    public Company(boolean active, int age, Contact contact, String name, String... founders) {
        this.active = active;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.founders = founders;
    }

    @Override
    public String toString() {
        return "Company{"
                + "active=" + active
                + ", age=" + age
                + ", name=" + name
                + ", contact=" + contact
                + ", founders=" + Arrays.toString(founders)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Company company = new Company(true, 1, new Contact(185543, "+7(821)222-22-22"),
                "CompanyCO", "Alexander Popov", "Maxim Samoilov", "Anna Semyonova");

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(company, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Company result = (Company) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}