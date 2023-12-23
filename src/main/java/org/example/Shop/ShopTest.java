package org.example.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Сыр", 20));
        products.add(new Product("Виски", 30));
        products.add(new Product("Колбаса", 10));

        Shop shop = new Shop(products);

//        1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).

        assertThat(shop.getProducts())
                .isNotEmpty()             // Массив не должен быть пустым
                .hasSize(3)               // Размер массива должен быть равен 7
                .doesNotHaveDuplicates()  // Массив не должен содержать повторяющихся элементов
                .extracting("title")
                .contains("Сыр", "Колбаса", "Виски");

//        3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).

        testSortProductsByPrice(shop);

//        2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.

        testGetMostExpensiveProduct ();
    }

    public static void testSortProductsByPrice(Shop shop) {
        Shop.sortProductsByPrice();
        assertThat(shop.getProducts())
                .isNotEmpty()             // Массив не должен быть пустым
                .hasSize(3)               // Размер массива должен быть равен 3
                .doesNotHaveDuplicates()  // Массив не должен содержать повторяющихся элементов
                .extracting("title")
                .contains("Сыр", "Колбаса", "Виски")
                .containsSequence("Колбаса", "Сыр", "Виски");
    }

    public static void testGetMostExpensiveProduct () {
        assertThat(Shop.getMostExpensiveProduct().getTitle()).isEqualTo("Виски");
    }
}
