package com.microservice.salesorder.been;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductListBo {

	
	 private static final long serialVersionUID = 2L;
	 
	  
	  @JsonProperty("productName")
	    private String productName;

	    @JsonProperty("instock")
	    private int instock;

	    @JsonProperty("perUnitPrice")
	    private double perUnitPrice;

	    @JsonProperty("unitRequired")
	    private int unitRequired;

	    @JsonProperty("subTotal")
	    private double subTotal;

	    @JsonProperty("tax")
	    private double tax;

	    @JsonProperty("discount")
	    private double discount;

	    @JsonProperty("total")
	    private double total;

	    @JsonProperty("productId")
	    private int productId;

	    @JsonProperty("priceBookId")
	    private int priceBookId;
		
	  public ProductListBo() {}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


		
		
		
		
		
		
		

	

}
