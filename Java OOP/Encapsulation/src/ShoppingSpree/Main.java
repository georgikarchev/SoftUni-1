package ShoppingSpree;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        HashMap<String, Product> productsList = new HashMap<>();

        try {
            String[] people = scanner.nextLine().split(";");
            for (String personData : people) {
                int indexOfEqual = personData.indexOf("=");
                String name = personData.substring(0, indexOfEqual);
                double money = Double.valueOf(personData.substring(indexOfEqual+1));
                Person person = new Person(name, money);
                personList.add(person);
            }

            String[] products = scanner.nextLine().split(";");
            for (String productData : products) {
                int indexOfEqual = productData.indexOf("=");
                String productName = productData.substring(0,indexOfEqual);
                double productCost = Double.parseDouble(productData.substring(indexOfEqual+1));
                Product product = new Product(productName,productCost);
                productsList.put(productName,product);
            }

            while (true) {
                String[] params = scanner.nextLine().split("\\s+");
                if (params[0].equals("END")) {
                    break;
                }
                String currentPersonName = params[0];
                String productName = params[1];
                for (Person person : personList) {
                    if (person.getName().equals(currentPersonName)) {
                        person.buyProduct(productsList.get(productName));
                    }
                }
            }

            for (Person currentPerson: personList) {
                currentPerson.getPurchases();
            }


        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

