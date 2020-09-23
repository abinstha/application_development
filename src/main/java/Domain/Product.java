/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class Product {

    /**
     * @return the manufacture_date
     */
    public Date getManufacture_date() {
        return manufacture_date;
    }

    /**
     * @param manufacture_date the manufacture_date to set
     */
    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    /**
     * @return the expire_date
     */
    public Date getExpire_date() {
        return expire_date;
    }

    /**
     * @param expire_date the expire_date to set
     */
    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the category_id
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the product_code
     */
    public Integer getProduct_code() {
        return product_code;
    }

    /**
     * @param product_code the product_code to set
     */
    public void setProduct_code(Integer product_code) {
        this.product_code = product_code;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the brand_name
     */
    public String getBrand_name() {
        return brand_name;
    }

    /**
     * @param brand_name the brand_name to set
     */
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    
    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    private Integer id;
    private String name;
    private String description;
    private Integer stock;
    private Integer category_id;
    private Integer product_code;
    private Double price;
    private String brand_name;
    
    private Date manufacture_date;
    private Date expire_date;
    private Double amount;
    
    private String size;
    private String gender;
    
    private Double weight;
    
}
