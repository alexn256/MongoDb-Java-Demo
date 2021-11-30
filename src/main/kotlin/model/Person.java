package model;

import org.bson.types.ObjectId;

public class Person {

    private ObjectId id;
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Person() {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String value = "Person=[";
        if (id != null) {
            value = "id=" + id.toString() + ", ";
        }
        value = value + "name=" + name + ", age=" + age;
        if (address != null) {
            value =  value + ", address=[" + address.toString() + "]";
        }
        return value + "]";
    }
}
