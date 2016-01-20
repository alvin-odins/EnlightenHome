package com.enlightenhome.image.model;

import java.io.InputStream;
import java.sql.Blob;

public class Image {
	
	private String Property_Id;
	private String Category_Id;
	private String Country;
	private String State;
	private String City;
	private String Region;
	private String Posted_By;
	private int Area;
	private float Rate;
	private float Lumpsum_Cost;
	private InputStream inputStream;
	
	
	public String getProperty_Id() {
		return Property_Id;
	}
	public void setProperty_Id(String property_Id) {
		Property_Id = property_Id;
	}
	public String getCategory_Id() {
		return Category_Id;
	}
	public void setCategory_Id(String category_Id) {
		Category_Id = category_Id;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getPosted_By() {
		return Posted_By;
	}
	public void setPosted_By(String posted_By) {
		Posted_By = posted_By;
	}
	
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
	public float getRate() {
		return Rate;
	}
	public void setRate(float rate) {
		Rate = rate;
	}
	public float getLumpsum_Cost() {
		return Lumpsum_Cost;
	}
	public void setLumpsum_Cost(float lumpsum_Cost) {
		Lumpsum_Cost = lumpsum_Cost;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	
	
}
