package com.job.elastic.springelasticdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Holds the details of product.
 */

@Data
@JacksonXmlRootElement(localName = "product")
@Document(indexName = "product")
public class ProductEntity {

  @Id
  @JacksonXmlProperty(isAttribute = true)
  private Integer id;

  @JacksonXmlProperty(localName = "category_id")
  @Field(name="categoryId", type = FieldType.Integer)
  private Integer categoryId;

  @JacksonXmlProperty(localName = "name")
  @Field(type = FieldType.Text)
  private String name;

  @JacksonXmlProperty(localName = "description")
  @Field(type = FieldType.Text)
  private String description;

  @JacksonXmlProperty(localName = "price")
  @Field(type = FieldType.Integer)
  private Integer price;

  @JacksonXmlProperty(localName = "picture")
  @Field(type = FieldType.Text)
  private String picture;

}
