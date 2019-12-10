package ShoppingSpree;

class Product {
    private String name;
    private double cost;

    Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if(name.isEmpty()|| name.trim().length() == 0){
           throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if(cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    double getCost() {
        return cost;
    }

    String getName() {
        return name;
    }


}
