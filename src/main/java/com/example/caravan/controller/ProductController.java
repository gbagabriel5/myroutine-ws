package com.example.caravan.controller;

import com.example.caravan.dto.ProductDTO;
import com.example.caravan.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(value = "Product Controller")
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Create Product")
    public ProductDTO create(@ApiParam(value = "Product") @RequestBody @Valid ProductDTO dto) {
        return productService.create(dto);
    }

    @PutMapping
    @ApiOperation(value = "Update Product")
    public ProductDTO update(@ApiParam(value = "Product") @RequestBody @Valid ProductDTO dto) {
        return productService.update(dto);
    }

    @GetMapping("getByName")
    @ApiOperation(value = "List by Name")
    public List<ProductDTO> findByName(@RequestParam(value = "name", required = false) String name) {
        return productService.getByName(name);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Product by ID")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
