package com.example.productservice.controller;


import com.example.productservice.VO.ResponseTemplateVO;
import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired

    private ProductService productService;
    @PostMapping("/create")

    public Product saveprProduct(@RequestBody Product product){
    return productService.saveProduct(product);
    }

  //@GetMapping("/fetch/{id}")
    //public Product findProductById(@PathVariable("id") Long productId){
    //return productService.findProductById(productId);

    @GetMapping("/")
    public ResponseTemplateVO getProductWithUserOne(@PathVariable("id")Long userId){
        return productService.getProductWithUserOne(userId);
  }
}
