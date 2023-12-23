package org.example.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private static List<Product> products;

    public Shop(List<Product> products) {
        Shop.products = products;
    }


    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        Shop.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public static void sortProductsByPrice() {

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product a1, Product a2) {
                return a1.getCost() - a2.getCost();
            }
        });
    }

    // Метод должен вернуть самый дорогой продукт
    public static Product getMostExpensiveProduct() {
        sortProductsByPrice();
        return products.get(products.size() - 1);
    }

}
