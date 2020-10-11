package com.job.elastic.springelasticdemo.service;
import com.job.elastic.springelasticdemo.model.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface ProductService {
  void safe(Collection<ProductEntity> categoryEntities);
  Page<ProductEntity> findByCategory(Integer categoryId, Pageable pageable);
  Page<ProductEntity> fullTextSearch(String query, Pageable pageable);
}
