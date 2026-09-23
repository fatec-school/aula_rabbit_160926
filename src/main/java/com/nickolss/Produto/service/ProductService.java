package com.nickolss.Produto.service;

import com.nickolss.Produto.entity.Product;
import com.nickolss.Produto.event.ProductEvent;
import com.nickolss.Produto.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductEvent productEvent;

    public ProductService(ProductRepository productRepository, ProductEvent productEvent) {
        this.productRepository = productRepository;
        this.productEvent = productEvent;
    }

    public List<Product> findAll() {
        productEvent.send("ProductService: findAll called");
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        productEvent.send("ProductService: findById called with id: " + id);
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        productEvent.send("ProductService: save called with product: " + product);
        return productRepository.save(product);
    }

    public Optional<Product> update(Long id, Product product) {
        productEvent.send("ProductService: update called with id: " + id + " and product: " + product);
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setImages(product.getImages());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setStock(product.getStock());
                    existingProduct.setEvaluation(product.getEvaluation());
                    existingProduct.setActive(product.isActive());
                    return productRepository.save(existingProduct);
                });
    }

    public boolean deleteById(Long id) {
        productEvent.send("ProductService: deleteById called with id: " + id);
        if (!productRepository.existsById(id)) {
            return false;
        }

        productRepository.deleteById(id);
        return true;
    }
}
