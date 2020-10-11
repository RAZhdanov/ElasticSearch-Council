package com.job.elastic.springelasticdemo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@JacksonXmlRootElement(localName = "delivery_service")
@Document(indexName = "deliveryService")
public class DeliveryServiceEntity {

  @JacksonXmlElementWrapper(localName = "categories")
  @JacksonXmlProperty(localName = "category")
  @Field(type = FieldType.Nested, includeInParent = true)
  private CategoryEntity[] categories;

  @JacksonXmlElementWrapper(localName = "products")
  @JacksonXmlProperty(localName = "product")
  @Field(type = FieldType.Nested, includeInParent = true)
  private ProductEntity[] products;
}
