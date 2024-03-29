package ru.netology.domain;

public class ShopRepository {
    private Product[] products = new Product[0];


    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    private void checkId(int id) {
        for (Product product : products) {
            if (product.id == id) {
                throw new AlreadyExistsException("Продукт с ID" + id + "уже добавлен");
            }
        }
    }


    public void add(Product product) {
        checkId(product.id);
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }


    public void remove(int id) {

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


    public Product findById(int ID) {
        for (Product product : products) {
            if (product.getId() == ID) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("ID" + id + "не найден");
        }
        remove(id);
    }
}
