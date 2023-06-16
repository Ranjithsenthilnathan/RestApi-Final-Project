package com.example.app.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BiddingWarsModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custid;
	private String custname;
	private String custnumber;
	private String address;
	private String productname;
	private float actualrate;
	private float sellingrate;
	private String productwarranty;
	private String productcolour;
	private String boughton;
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustnumber() {
		return custnumber;
	}
	public void setCustnumber(String custnumber) {
		this.custnumber = custnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getActualrate() {
		return actualrate;
	}
	public void setActualrate(float actualrate) {
		this.actualrate = actualrate;
	}
	public float getSellingrate() {
		return sellingrate;
	}
	public void setSellingrate(float sellingrate) {
		this.sellingrate = sellingrate;
	}
	public String getProductwarranty() {
		return productwarranty;
	}
	public void setProductwarranty(String productwarranty) {
		this.productwarranty = productwarranty;
	}
	public String getProductcolour() {
		return productcolour;
	}
	public void setProductcolour(String productcolour) {
		this.productcolour = productcolour;
	}
	public String getBoughton() {
		return boughton;
	}
	public void setBoughton(String boughton) {
		this.boughton = boughton;
	}
	@Override
	public String toString() {
		return "BiddingWarsModel [custid=" + custid + ", custname=" + custname + ", custnumber=" + custnumber
				+ ", address=" + address + ", productname=" + productname + ", actualrate=" + actualrate
				+ ", sellingrate=" + sellingrate + ", productwarranty=" + productwarranty + ", productcolour="
				+ productcolour + ", boughton=" + boughton + "]";
	}
	
}
