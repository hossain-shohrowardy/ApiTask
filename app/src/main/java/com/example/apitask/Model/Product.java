package com.example.apitask.Model;

public class Product {
     private Integer id;
     private String categoryName;
     private String unitName;
     private String name;
     private Integer code;
     private Integer productBarcode;
     private String description;
     private String brandName;
     private String sizeName;
     private String colorName;
     private String modelName;
     private Double price;
     private Double oldPrice;
     private String imagePath;

     public Product(){

     }

     public Product(Integer id, String categoryName, String unitName, String name, Integer code, Integer productBarcode, String description, String brandName, String sizeName, String colorName, String modelName, Double price, Double oldPrice, String imagePath) {
          this.id = id;
          this.categoryName = categoryName;
          this.unitName = unitName;
          this.name = name;
          this.code = code;
          this.productBarcode = productBarcode;
          this.description = description;
          this.brandName = brandName;
          this.sizeName = sizeName;
          this.colorName = colorName;
          this.modelName = modelName;
          this.price = price;
          this.oldPrice = oldPrice;
          this.imagePath = imagePath;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getCategoryName() {
          return categoryName;
     }

     public void setCategoryName(String categoryName) {
          this.categoryName = categoryName;
     }

     public String getUnitName() {
          return unitName;
     }

     public void setUnitName(String unitName) {
          this.unitName = unitName;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Integer getCode() {
          return code;
     }

     public void setCode(Integer code) {
          this.code = code;
     }

     public Integer getProductBarcode() {
          return productBarcode;
     }

     public void setProductBarcode(Integer productBarcode) {
          this.productBarcode = productBarcode;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getBrandName() {
          return brandName;
     }

     public void setBrandName(String brandName) {
          this.brandName = brandName;
     }

     public String getSizeName() {
          return sizeName;
     }

     public void setSizeName(String sizeName) {
          this.sizeName = sizeName;
     }

     public String getColorName() {
          return colorName;
     }

     public void setColorName(String colorName) {
          this.colorName = colorName;
     }

     public String getModelName() {
          return modelName;
     }

     public void setModelName(String modelName) {
          this.modelName = modelName;
     }

     public Double getPrice() {
          return price;
     }

     public void setPrice(Double price) {
          this.price = price;
     }

     public Double getOldPrice() {
          return oldPrice;
     }

     public void setOldPrice(Double oldPrice) {
          this.oldPrice = oldPrice;
     }

     public String getImagePath() {
          return imagePath;
     }

     public void setImagePath(String imagePath) {
          this.imagePath = imagePath;
     }
}
