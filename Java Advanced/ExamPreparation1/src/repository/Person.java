package repository;

public class Person {
    public String name;
    public int age;
    public String birthDate;

    public Person( String name, int age, String birthDate) {
        this.age = age;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nAge: %d%nBirthday: %s%n", this.name, this.age, this.birthDate);
    }
}
