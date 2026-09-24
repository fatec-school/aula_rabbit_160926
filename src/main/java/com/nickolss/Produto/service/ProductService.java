package com.nickolss.Produto.service;

import com.nickolss.Produto.controller.dto.SellResponse;
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
        SellResponse message = new SellResponse(0L, 0, "ProductService: findAll called");
        productEvent.send(message);
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        SellResponse message = new SellResponse(id, 0, "ProductService: findById called with id: " + id);
        productEvent.send(message);
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        SellResponse message = new SellResponse(product.getId(), 0, "Product saved successfully");
        productEvent.send(message);
        return productRepository.save(product);
    }

    public Optional<Product> update(Long id, Product product) {
        SellResponse message = new SellResponse(id, 0, "Product updated successfully");
        productEvent.send(message);
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
        SellResponse message = new SellResponse(id, 0, "Product deleted successfully");
        productEvent.send(message);
        if (!productRepository.existsById(id)) {
            return false;
        }

        productRepository.deleteById(id);
        return true;
    }
}
