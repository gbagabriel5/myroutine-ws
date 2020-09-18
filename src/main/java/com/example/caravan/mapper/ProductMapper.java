package com.example.caravan.mapper;

import com.example.caravan.domain.Product;
import com.example.caravan.dto.ProductDTO;

import java.util.Optional;

public class ProductMapper {
    public ProductDTO convertToDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setQuantity(entity.getQuantity());
        dto.setDate(entity.getDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Product convertToEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setDate(dto.getDate());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public Product convertToUpdate(Product product, Optional<Product> productReturn) {
        product.setId(productReturn.get().getId());
        if(productReturn.get().getName() != null)
            product.setName(productReturn.get().getName());
        if(productReturn.get().getName() != null)
            product.setName(productReturn.get().getName());
        if(productReturn.get().getQuantity() != null)
            product.setQuantity(productReturn.get().getQuantity());
        if(productReturn.get().getDate() != null)
            product.setDate(productReturn.get().getDate());
        if(productReturn.get().getStatus() != null)
            product.setStatus(productReturn.get().getStatus());
        return product;
    }
}
