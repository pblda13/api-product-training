package com.project.product.apiproduct.service;


import com.project.product.apiproduct.model.Product;
import com.project.product.apiproduct.repositories.PoductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
@Autowired
    private PoductRepository poductRepository;


public Product create(Product product ){
   return poductRepository.save(product);
}

    public Optional<Product> findById(long id ){
        return poductRepository.findById(id);
    }

    public List<Product> findAll( ){
        return poductRepository.findAll();
    }

    public Product update(Product product ) throws Exception {

        var entity = poductRepository.findById(product.getId())
                .orElseThrow(() -> new Exception("No records found for this ID!"));

        entity.setName(product.getName());
        entity.setLastname(product.getLastname());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());

        return poductRepository.save(product);
    }

public boolean delete(Long id) throws Exception {
    var entity = poductRepository.findById(id)
            .orElseThrow(() -> new Exception("No records found for this ID!"));
    poductRepository.delete(entity);
    return true;
}


}
