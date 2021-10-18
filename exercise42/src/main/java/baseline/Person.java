package baseline;

public class Person {
    // Variables to store Person's name and salary
    String first;
    String last;
    int salary;

    // Constructor
    Person(String first, String last, int salary) {
        this.first = first;
        this.last = last;
        this.salary = salary;
    }

    // == Getters and setters ==

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
