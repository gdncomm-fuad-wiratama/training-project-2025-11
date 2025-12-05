package com.bootcamp.product.controller;

import com.bootcamp.product.model.Product;
import com.bootcamp.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @RequestMapping(path = "/member", method = RequestMethod.GET)
  public Product getMember(String email) {
    return productRepository.findByEmail(email);
  }

  @RequestMapping(path = "/member", method = RequestMethod.POST)
  public Product createMember(@RequestBody Product productRequest) {
    return productRepository.save(productRequest);
  }
}
