package com.job.elastic.springelasticdemo.controller;

import com.job.elastic.springelasticdemo.config.ElasticSearchConfiguration;
import com.job.elastic.springelasticdemo.model.ProductEntity;
import com.job.elastic.springelasticdemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Zhdanov Ramzes
 */

@RestController
@RequestMapping(value = "/api/v1/multiSearch")
@Slf4j
public class SearchController {


  private final ProductService productService;

  @Autowired
  public SearchController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<Collection<ProductEntity>> doMultiSearch(@RequestParam String query, Pageable pageable){
    try{
      Page<ProductEntity> productEntities = productService.fullTextSearch(query, pageable);
      return new ResponseEntity<>(productEntities.getContent(), HttpStatus.OK);
    } catch(Exception e){
      log.error(e.getMessage(), e);
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }

  @GetMapping("/products/categories/{id}")
  public ResponseEntity<Collection<ProductEntity>> filterByCategoryId(@PathVariable(name = "id") Integer id, Pageable pageable){
    try {
      Page<ProductEntity> categories = productService.findByCategory(id, pageable);
      return new ResponseEntity<>(categories.getContent(), HttpStatus.OK);
    } catch (Exception e){
      log.error(e.getMessage(), e);
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }
}
