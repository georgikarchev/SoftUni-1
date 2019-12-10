package AnimalFarm;

import java.security.InvalidParameterException;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if(name.trim().length() <= 0){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private  double calculateProductPerDay(){
        double product = 0;
        if(this.age >= 0 && this.age <= 5 ){
            product = 2;
            return  product;
        }else if(this.age >=6 && this.age <= 11){
            product = 1;
            return product;
        }else {
            product = 0.75;
            return product;
        }

    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.", this.getName(), this.getAge(),
                this.productPerDay());
    }
}
