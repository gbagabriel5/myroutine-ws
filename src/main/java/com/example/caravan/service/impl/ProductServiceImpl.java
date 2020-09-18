package com.example.caravan.service.impl;

import com.example.caravan.domain.Product;
import com.example.caravan.dto.ProductDTO;
import com.example.caravan.exception.NotFoundException;
import com.example.caravan.mapper.ProductMapper;
import com.example.caravan.repository.ProductRepository;
import com.example.caravan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    private ProductMapper productMapper = new ProductMapper();

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product product = productMapper.convertToEntity(dto);
        product.setDate(new Date());
        product = repository.save(product);
        dto = productMapper.convertToDTO(product);
        return dto;
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Product product = productMapper.convertToEntity(dto);
        Optional<Product> productReturn = repository.findById(product.getId());
        if (productReturn.isPresent())
            product = repository.save(productMapper.convertToUpdate(product, productReturn));
        else
            throw new NotFoundException("Produto nao encontrado!");
        dto = productMapper.convertToDTO(product);
        return dto;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getByName(String name) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        if(name != null) {
            List<Product> listByName = repository.findByNameIgnoreCaseContaining(name);
            listByName.forEach(products -> productDTOS.add(productMapper.convertToDTO(products)));
        }else {
            List<Product> listAll = repository.findAll();
            listAll.forEach(products -> productDTOS.add(productMapper.convertToDTO(products)));
        }
        return productDTOS;
    }
}
