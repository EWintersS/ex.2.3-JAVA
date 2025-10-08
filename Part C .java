import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;
    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

public class PartC {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("TV", 60000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Jeans", 2500, "Clothing"),
            new Product("Sofa", 30000, "Furniture"),
            new Product("Table", 12000, "Furniture")
        );

        System.out.println("Group by Category:");
        Map<String, List<Product>> group = list.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        group.forEach((cat, prods) -> {
            System.out.println(cat + ":");
            prods.forEach(p -> System.out.println("  " + p.name));
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> max = list.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));
        max.forEach((cat, prod) ->
            System.out.println(cat + ": " + prod.get().name + " - " + prod.get().price));

        System.out.println("\nAverage Price of All Products:");
        double avg = list.stream()
            .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println(avg);
    }
}
