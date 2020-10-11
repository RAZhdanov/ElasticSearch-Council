package com.job.elastic.springelasticdemo.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.job.elastic.springelasticdemo.dto.LinkDtoRequest;
import com.job.elastic.springelasticdemo.dto.LinkDtoResponse;
import com.job.elastic.springelasticdemo.model.CategoryEntity;
import com.job.elastic.springelasticdemo.model.DcCatalogEntity;
import com.job.elastic.springelasticdemo.model.ProductEntity;
import com.job.elastic.springelasticdemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Arrays;

/**
 * @author Zhdanov Ramzes
 */

@RestController
@RequestMapping(value = "/api/v1/upload")
@Slf4j
public class UploadController {

  private final ProductService productService;

  @Autowired
  public UploadController(ProductService productService) {
    this.productService = productService;
  }


  @PostMapping
  public ResponseEntity<LinkDtoResponse> upload(@RequestBody LinkDtoRequest dto,
                                                HttpServletRequest request) {
    log.info("Enter into upload: {}", dto);
    try
    {
      URL xmlUrl = new URL(dto.getStrUrlLink());

      log.info("Url is : {}", xmlUrl);

      XmlMapper xmlMapper = new XmlMapper();
      DcCatalogEntity dcCatalogEntity = xmlMapper.readValue(xmlUrl,DcCatalogEntity.class);

      log.info("dcCatalogEntity is : {}", dcCatalogEntity);

      if(dcCatalogEntity != null){
        ProductEntity[] products = dcCatalogEntity.getDeliveryService().getProducts();
        productService.safe(Arrays.asList(products));
        log.info("product is saved");
      }


      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      log.error(e.getMessage(), e);
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }
}
