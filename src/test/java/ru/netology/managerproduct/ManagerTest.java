package ru.netology.managerproduct;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.managerproduct.domain.Book;
import ru.netology.managerproduct.domain.Product;
import ru.netology.managerproduct.domain.Smartphone;
import ru.netology.managerproduct.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void searchBookByNamePart() {
        // given
        Manager manager = new Manager(new ProductRepository());
        Product book = new Book(3, "King Arthur", 1500, "Author");
        Product[] books = {book};
        manager.saveAllProducts(books);

        Product[] foundBooks = manager.searchBy("King");
        assertEquals(foundBooks.length, 1);
        assertEquals(foundBooks[0], book);
    }

    @Test
    void searchBookByAuthorPart() {
        // given
        Manager manager = new Manager(new ProductRepository());
        Product book = new Book(3, "King Arthur", 1500, "Author");
        Product[] books = {book};
        manager.saveAllProducts(books);

        Product[] foundBooks = manager.searchBy("Author");
        assertEquals(foundBooks.length, 1);
        assertEquals(foundBooks[0], book);
    }

    @Test
    void searchSmartphoneByNamePart() {
        // given
        Manager manager = new Manager(new ProductRepository());
        Product smartphone = new Smartphone(5, "Iphone11", 50000, "Apple");
        Product[] Smartphones = {smartphone};
        manager.saveAllProducts(Smartphones);

        Product[] foundSmartphones = manager.searchBy("Iphone11");
        assertEquals(foundSmartphones.length, 1);
        assertEquals(foundSmartphones[0], smartphone);
    }

    @Test
    void searchSmartphoneByCreator() {
        // given
        Manager manager = new Manager(new ProductRepository());
        Product smartphone = new Smartphone(5, "Iphone11", 50000, "Apple");
        Product[] Smartphones = {smartphone};
        manager.saveAllProducts(Smartphones);

        Product[] foundSmartphones = manager.searchBy("Apple");
        assertEquals(foundSmartphones.length, 1);
        assertEquals(foundSmartphones[0], smartphone);
    }

    @Test
    void shouldNotSearchProductByIncorrectName() {
        // given
        Manager manager = new Manager(new ProductRepository());
        Product product = new Product(5, "Iphone11", 50000);
        Product[] products = {product};
        manager.saveAllProducts(products);

        Product[] foundProducts = manager.searchBy("Pen");
        assertEquals(foundProducts.length, 0);

    }
}