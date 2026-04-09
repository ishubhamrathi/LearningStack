package LLD.ProxyDesignPattern.models;

public class EmployeeEntity {
    String name;
    int age;
    int id;

    public EmployeeEntity(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String prettyEmployeeDetails() {
        return "Id: " + this.id + " Name: " + this.name + " Age: " + this.age;
    }
}
