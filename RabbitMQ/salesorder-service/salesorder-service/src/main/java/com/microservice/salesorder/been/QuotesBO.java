package com.microservice.salesorder.been;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotesBO {
	
	
	 private static final long serialVersionUID = 1L;

	private String createdBy;
	
	private long employeeId;
	
	private String accountName;
	
	private long accountId;
	
	private String email;
	
	private String creationDate;

	private String dueDate;
	
	private String status;
	
	private String priceBookId;
	
	private long pricebookProductID;
	
	private long accountPhoneNumber;
	
	private long employeePhoneNumbers;
	
	private String product;
	
	private long productId;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private long pincode;
	
	private long perUnit;
	
	private long unitReqired;
	
	private long discount;
	
	private long tax;
	
	private long instock;
	
	private long perUnitPrice;
	
	private long total;
	
	private long SubTotal;
	
	private String assignedTo;
	
	private String quotesUni;
	
	private boolean isDelete;
	
	
	private long quotesId;
	
	 @JsonProperty("productListArr")
	 private List<ProductListBo> productListArr;
	 

	private long allProductSubTotak;
	
	private long allProducttotal;
	
	
	
	
	
	
	

	public long getAccountPhoneNumber() {
		return accountPhoneNumber;
	}

	public void setAccountPhoneNumber(long accountPhoneNumber) {
		this.accountPhoneNumber = accountPhoneNumber;
	}

	public long getEmployeePhoneNumbers() {
		return employeePhoneNumbers;
	}

	public void setEmployeePhoneNumbers(long employeePhoneNumbers) {
		this.employeePhoneNumbers = employeePhoneNumbers;
	}

	public long getAllProductSubTotak() {
		return allProductSubTotak;
	}

	public void setAllProductSubTotak(long allProductSubTotak) {
		this.allProductSubTotak = allProductSubTotak;
	}

	public long getAllProducttotal() {
		return allProducttotal;
	}

	public void setAllProducttotal(long allProducttotal) {
		this.allProducttotal = allProducttotal;
	}

	public List<ProductListBo> getProductListArr() {
		return productListArr;
	}

	public void setProductListArr(List<ProductListBo> productListArr) {
		this.productListArr = productListArr;
	}

	public long getQuotesId() {
		return quotesId;
	}

	public void setQuotesId(long quotesId) {
		this.quotesId = quotesId;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getQuotesUni() {
		return quotesUni;
	}

	public void setQuotesUni(String quotesUni) {
		this.quotesUni = quotesUni;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriceBookId() {
		return priceBookId;
	}

	public void setPriceBookId(String priceBookId) {
		this.priceBookId = priceBookId;
	}

	public long getPricebookProductID() {
		return pricebookProductID;
	}

	public void setPricebookProductID(long pricebookProductID) {
		this.pricebookProductID = pricebookProductID;
	}

	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public long getPerUnit() {
		return perUnit;
	}

	public void setPerUnit(long perUnit) {
		this.perUnit = perUnit;
	}

	public long getUnitReqired() {
		return unitReqired;
	}

	public void setUnitReqired(long unitReqired) {
		this.unitReqired = unitReqired;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public long getInstock() {
		return instock;
	}

	public void setInstock(long instock) {
		this.instock = instock;
	}

	public long getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(long perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(long subTotal) {
		SubTotal = subTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
