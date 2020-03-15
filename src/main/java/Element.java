import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Element {
    String name;
    List<Element> preferences = new ArrayList<>();
    int capacity;

    public Element() {
    }

    public Element(String name) {
        this(name, 1);
    }

    public Element(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void minusCapacity() {
        capacity--;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Element> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Element> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public List<Element> getPreferencesBefore(Element element) {
        List<Element> superior = new ArrayList<>();
        for (Element p : preferences) {
            if (p.equals(element)) {
                break;
            }
            superior.add(p);
        }
        return superior;
    }

    public boolean prefersFirstBetter(Element first, Element second) {
        int i1 = preferences.indexOf(first);
        int i2 = preferences.indexOf(second);
        if (i1 != -1 && i2 != -1)
            return i1<i2;

        System.out.println("eroare prefersFirstBetter");
        return false;
    }

    public Element randomElement()
    {
        Faker faker = new Faker();
        name = faker.name().lastName();
        capacity = (int)(Math.random() * (10 - 1) + 1);
        return this;
    }
}
