package ru.geekbrains.happy.market.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.model.Product;
import ru.geekbrains.happy.market.repositories.ProductRepository;
import ru.geekbrains.happy.market.soap.products.ProductSOAP;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceSOAP {
    private final ProductRepository productRepository;
    private final ProductService productService;

    public static final Function<Product, ProductSOAP> functionEntityToSoap = product -> {
        ProductSOAP productSOAP = new ProductSOAP();
        productSOAP.setId(product.getId());
        productSOAP.setTitle(product.getTitle());
        productSOAP.setPrice(product.getPrice());
        return productSOAP;
    };

    public List<ProductSOAP> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public ProductSOAP getProductById(Long id) {
        return productRepository.findById(id).map(functionEntityToSoap).get();
    }
}
