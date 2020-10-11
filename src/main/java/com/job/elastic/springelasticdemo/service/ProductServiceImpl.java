package com.job.elastic.springelasticdemo.service;

import com.job.elastic.springelasticdemo.model.ProductEntity;
import com.job.elastic.springelasticdemo.repository.ProductRepo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

@Service
public class ProductServiceImpl implements ProductService{

  private final ProductRepo repo;

  @Autowired
  public ProductServiceImpl(ProductRepo repo) {
    this.repo = repo;
  }

  @Override
  public void safe(Collection<ProductEntity> categoryEntities) {
    repo.saveAll(categoryEntities);
  }

  //полнотекстовый поиск
  @Override
  public Page<ProductEntity> fullTextSearch(String query, Pageable pageable) {

    QueryStringQueryBuilder queryStringQuery = QueryBuilders.queryStringQuery(query);
    queryStringQuery.type(MultiMatchQueryBuilder.Type.PHRASE);

    BoolQueryBuilder queryBuilder = boolQuery().must(queryStringQuery);

    return repo.search(queryBuilder, pageable);
  }


  //фильтрация по ид категории
  public Page<ProductEntity> findByCategory(Integer categoryId, Pageable pageable){
    return repo.findByCategoryId(categoryId, pageable);
  }
}
