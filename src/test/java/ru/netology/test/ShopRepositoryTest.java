package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.ShopRepository;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "хлеб", 20);
    Product product2 = new Product(22, "молоко", 57);
    Product product3 = new Product(333, "курица", 300);

    ShopRepository repo = new ShopRepository();

    @Test
    public void ShouldTrows(){

       repo.add(product1);
       repo.add(product2);
       repo.add(product3);


       Assertions.assertThrows(NotFoundException.class, ()  -> {repo.removeById(45);});

    }
}


