package ShoppingSpree;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().length() == 0 || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    String getName() {
        return name;
    }

    private double getMoney() {
        return money;
    }

    void buyProduct(Product product){
       if(this.getMoney() > product.getCost()){
           this.money = this.getMoney() - product.getCost();
           this.products.add(product);
           System.out.printf("%s bought %s\n", this.getName(), product.getName());
       }else {
           System.out.printf("%s can't afford %s\n", this.name, product.getName());
       }
    }

    void getPurchases() {
        if (this.products.size() == 0) {
            System.out.printf("%s - Nothing bought\n", this.name);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s - ", this.name));
            for (Product product : this.products) {
                sb.append(String.format("%s, ", product.getName()));
            }

            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb.toString());
        }
    }
}
