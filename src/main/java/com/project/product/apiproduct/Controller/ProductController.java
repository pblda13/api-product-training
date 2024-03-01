package com.project.product.apiproduct.Controller;

import com.project.product.apiproduct.model.Product;
import com.project.product.apiproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/vi/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    public ResponseEntity<Product> create(@RequestBody Product product) {
        var newProduct = productService.create(product);
        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        var newProduct = productService.findById(id);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getFindAll() {
        List<Product> newList = productService.findAll();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) throws Exception {
        product.setId(id);
        var updateProduct = productService.update(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);

    }

    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {

        boolean removido = productService.delete(id);

        if (removido == true) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
