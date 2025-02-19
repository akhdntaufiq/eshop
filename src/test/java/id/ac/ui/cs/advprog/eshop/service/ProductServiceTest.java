package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreate() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);
        assertNotNull(createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testEdit() {
        Product product = new Product();
        String productId = "123";
        when(productRepository.edit(product, productId)).thenReturn(product);

        Product editedProduct = productService.edit(product, productId);
        assertNotNull(editedProduct);
        verify(productRepository, times(1)).edit(product, productId);
    }

    @Test
    void testDelete() {
        String productId = "123";
        doNothing().when(productRepository).delete(productId);

        productService.delete(productId);
        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    void testFindById() {
        String productId = "123";
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);

        Product foundProduct = productService.findById(productId);
        assertNotNull(foundProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testFindAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        Iterator<Product> productIterator = products.iterator();

        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> result = productService.findAll();
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }
}
