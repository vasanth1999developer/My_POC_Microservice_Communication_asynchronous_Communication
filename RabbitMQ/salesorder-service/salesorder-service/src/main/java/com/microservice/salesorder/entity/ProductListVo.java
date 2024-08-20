package com.microservice.salesorder.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ProductList_table")
public class ProductListVo {
	
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	  
	
    private String productName;

    private int instock;

    private double perUnitPrice;

    private int unitRequired;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;

    private int productId;

    private int priceBookId;
    

    
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "quotesId", nullable = false)
    private QuotesEntity quotes;
    

	public QuotesEntity getQuotes() {
		return quotes;
	}

	public void setQuotes(QuotesEntity quotes) {
		this.quotes = quotes;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public double getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(double perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}

	public int getUnitRequired() {
		return unitRequired;
	}

	public void setUnitRequired(int unitRequired) {
		this.unitRequired = unitRequired;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPriceBookId() {
		return priceBookId;
	}

	public void setPriceBookId(int priceBookId) {
		this.priceBookId = priceBookId;
	}
    

}
