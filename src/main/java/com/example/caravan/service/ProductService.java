package com.example.caravan.service;


import com.example.caravan.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO dto);
    ProductDTO update(ProductDTO dto);
    void delete(Integer id);
    List<ProductDTO> getByName(String name);
}
