package ru.netology.managerproduct.repository;

import org.junit.jupiter.api.Test;
import ru.netology.managerproduct.NotFoundException;
import ru.netology.managerproduct.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryUnitTest {
    private static final String IPHONE = "iphone";
    private static final int ID = 1;

    @Test
    void shouldRemoveById() {
        ProductRepository productRepository = new ProductRepository();
        var testPhone = new Smartphone(1, IPHONE, 20, IPHONE);
        productRepository.save(testPhone);
        productRepository.removeById(ID);
        assertEquals(productRepository.findAll().length, 0);
    }

    @Test
    void shouldThrowNotFoundForUnknownId() {
        ProductRepository productRepository = new ProductRepository();
        assertThrows(NotFoundException.class, () -> productRepository.removeById(ID),
                "Element with id: " + ID + " not found");
    }
}