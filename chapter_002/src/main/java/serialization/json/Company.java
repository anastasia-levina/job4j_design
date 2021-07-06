package serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    private final boolean active;
    private final int age;
    private final String name;
    private final Contact contact;
    private final String[] founders;

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

    public static void main(String[] args) {

        JSONObject jsonContact = new JSONObject("{\"zipCode\":\"185543\",\"phone\":\"+7(821)222-22-22\"}");

        List<String> list = new ArrayList<>();
        list.add("Alexander Popov");
        list.add("Maxim Samoilov");
        list.add("Anna Semyonova");
        JSONArray jsonFounders = new JSONArray(list);

        final Company company = new Company(true, 1, new Contact(185543, "+7(821)222-22-22"),
                "CompanyCO", "Alexander Popov", "Maxim Samoilov", "Anna Semyonova");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("active", company.isActive());
        jsonObject.put("age", company.getAge());
        jsonObject.put("name", company.getName());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("founders", jsonFounders);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(company).toString());
    }

    public boolean isActive() {
        return active;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getFounders() {
        return founders;
    }
}