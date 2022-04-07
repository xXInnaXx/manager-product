package ru.netology.managerproduct;

import ru.netology.managerproduct.domain.Book;
import ru.netology.managerproduct.domain.Product;
import ru.netology.managerproduct.domain.Smartphone;
import ru.netology.managerproduct.repository.ProductRepository;

public class Manager {
    private ProductRepository productRepository;

    public Manager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveAllProducts(Product[] products) {
        for (Product product : products) {
            productRepository.save(product);
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        Product[] all = productRepository.findAll();
        for (Product product : all) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String text) {
        if (product instanceof Book) {
            if (((Book) product).getAuthor().contains(text)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            if (((Smartphone) product).getCreator().contains(text)) {
                return true;
            }
        }
        return product.getName().contains(text);
    }
}