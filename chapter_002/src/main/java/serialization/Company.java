package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

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
        final Company company = new Company(true, 1, new Contact(185543, "+7(821)222-22-22"),
                "CompanyCO", "Alexander Popov", "Maxim Samoilov", "Anna Semyonova");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(company));

        final String companyJson =
                "{"
                        + "\"active\":true,"
                        + "\"age\":1,"
                        + "\"name\":CompanyCO,"
                        + "\"contact\":"
                        + "{"
                        + "\"zipCode\":185543,"
                        + "\"phone\":\"+7(821)222-22-22\""
                        + "},"
                        + "\"founders\":"
                        + "[\"Alexander Popov\", \"Maxim Samoilov\", \"Anna Semyonova\"]"
                        + "}";
        final Company companyMod = gson.fromJson(companyJson, Company.class);
        System.out.println(companyMod);
    }
}