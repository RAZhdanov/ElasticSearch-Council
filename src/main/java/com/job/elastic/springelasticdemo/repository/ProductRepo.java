package com.job.elastic.springelasticdemo.repository;
import com.job.elastic.springelasticdemo.model.ProductEntity;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Holds the Elasticsearch CRUD operations for {@link ProductEntity} entity.
 */
@Repository
public interface ProductRepo extends ElasticsearchRepository<ProductEntity,Integer> {
    Page<ProductEntity> findByCategoryId(Integer categoryId, Pageable pageable);
}
