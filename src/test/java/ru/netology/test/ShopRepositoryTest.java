package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AlreadyExistsException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.ShopRepository;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "хлеб", 20);
    Product product2 = new Product(22, "молоко", 57);
    Product product3 = new Product(333, "курица", 300);
    Product product4 = new Product(22, "молоко", 57);

    ShopRepository repo = new ShopRepository();

    @Test
    public void ShouldTrowsNotFound() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(45);
        });

    }

    @Test
    public void shouldAdd() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowsAlreadyExists() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product4);
        });
    }
}


