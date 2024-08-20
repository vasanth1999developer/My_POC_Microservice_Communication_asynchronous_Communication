package com.microservice.salesorder.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.microservice.salesorder.been.ProductListBo;

@Entity
@Table(name="Quotes_table")
public class QuotesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quotesId;
	
	  @Column(unique = true)
	 private String quotesUniNumber;
	
	  private String createdBy;
		
		private long employeeId;
		
		private String accountName;
		
		private long accountId;
		
		private String email;
		
		private String creationDate;

		private String dueDate;
		
		private String status;
			
		private long pricebookProductID;
		
		private long AccountPhoneNumber;
		
		private long EmployeePhoneNumber;
		
		private String product;
		
		private String country;
		
		private String state;
		
		private String city;
		
		private String street;
		
		private long pincode;
		
		private String assignedTo;
		
		@Transient
		private String quotesUni;
		
		private boolean isDelete;
				
		private String modifiedOn;
		
		private String modifiedBy;
				
	    @OneToMany(mappedBy = "quotes", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<ProductListVo> productListArr ;

		
		
	
		
		
		
		

		public List<ProductListVo> getProductListArr() {
			return productListArr;
		}

		public void setProductListArr(List<ProductListVo> productListArr) {
			this.productListArr = productListArr;
		}

		public String getModifiedOn() {
			return modifiedOn;
		}

		public void setModifiedOn(String modifiedOn) {
			this.modifiedOn = modifiedOn;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public void setDelete(boolean isDelete) {
			this.isDelete = isDelete;
		}

		public boolean getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(boolean isDelete) {
			this.isDelete = isDelete;
		}

		

		public long getQuotesId() {
			return quotesId;
		}

		public void setQuotesId(long quotesId) {
			this.quotesId = quotesId;
		}

		public String getQuotesUniNumber() {
			return quotesUniNumber;
		}

		public void setQuotesUniNumber(String quotesUniNumber) {
			this.quotesUniNumber = quotesUniNumber;
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

//		public String getPriceBookId() {
//			return priceBookId;
//		}
//
//		public void setPriceBookId(String priceBookId) {
//			this.priceBookId = priceBookId;
//		}

		public long getPricebookProductID() {
			return pricebookProductID;
		}

		public void setPricebookProductID(long pricebookProductID) {
			this.pricebookProductID = pricebookProductID;
		}

		public long getAccountPhoneNumber() {
			return AccountPhoneNumber;
		}

		public void setAccountPhoneNumber(long accountPhoneNumber) {
			AccountPhoneNumber = accountPhoneNumber;
		}

		public long getEmployeePhoneNumber() {
			return EmployeePhoneNumber;
		}

		public void setEmployeePhoneNumber(long employeePhoneNumber) {
			EmployeePhoneNumber = employeePhoneNumber;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

//		public long getProductId() {
//			return productId;
//		}
//
//		public void setProductId(long productId) {
//			this.productId = productId;
//		}

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

		

//		public long getUnitReqired() {
//			return unitReqired;
//		}
//
//		public void setUnitReqired(long unitReqired) {
//			this.unitReqired = unitReqired;
//		}
//
//		public long getDiscount() {
//			return discount;
//		}
//
//		public void setDiscount(long discount) {
//			this.discount = discount;
//		}
//
//		public long getTax() {
//			return tax;
//		}
//
//		public void setTax(long tax) {
//			this.tax = tax;
//		}
//
//		public long getInstock() {
//			return instock;
//		}
//
//		public void setInstock(long instock) {
//			this.instock = instock;
//		}
//
//		public long getPerUnitPrice() {
//			return perUnitPrice;
//		}
//
//		public void setPerUnitPrice(long perUnitPrice) {
//			this.perUnitPrice = perUnitPrice;
//		}
//
//		public long getTotal() {
//			return total;
//		}
//
//		public void setTotal(long total) {
//			this.total = total;
//		}
//
//		public long getSubTotal() {
//			return SubTotal;
//		}
//
//		public void setSubTotal(long subTotal) {
//			SubTotal = subTotal;
//		}

		public String getAssignedTo() {
			return assignedTo;
		}

		public void setAssignedTo(String assignedTo) {
			this.assignedTo = assignedTo;
		}

		public String getQuotesUni() {
			return quotesUni;
		}

		public void setQuotesUni(String quotesUni) {
			this.quotesUni = quotesUni;
		}

		
		
		
	

	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
