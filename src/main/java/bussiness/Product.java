/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussiness;

/**
 *
 * @author rio
 */
public class Product {
    private String code;
    private String descriptions;
    private Double price;

    public Product(){
        
    }
    public Product(String prodCode, String prodName, Double prodPrice) {
        this.code = prodCode;
        this.descriptions = prodName;
        this.price = prodPrice;
    }

    public String getProdCode() {
        return code;
    }

    public String getProdName() {
        return descriptions;
    }

    public Double getProdPrice() {
        return price;
    }

    public void setProdCode(String prodID) {
        this.code = prodID;
    }

    public void setProdName(String prodName) {
        this.descriptions = prodName;
    }

    public void setProdPrice(Double prodPrice) {
        this.price = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "prodCode=" + code + ", prodName=" + descriptions + ", prodPrice=" + price + '}';
    }
    
}
