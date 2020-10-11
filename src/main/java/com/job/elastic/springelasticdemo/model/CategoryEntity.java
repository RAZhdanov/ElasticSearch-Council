package com.job.elastic.springelasticdemo.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@JacksonXmlRootElement(localName = "category")
@Document(indexName = "category")
public class CategoryEntity {

  @Id
  @JacksonXmlProperty(isAttribute = true)
  private Integer id;

  @JacksonXmlProperty(isAttribute = true)
  @Field(type = FieldType.Integer)
  private Integer parentId;

  @JacksonXmlText
  @Field(type = FieldType.Text)
  private String text;
}
