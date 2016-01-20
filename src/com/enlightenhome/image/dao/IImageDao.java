package com.enlightenhome.image.dao;

import java.util.List;

import com.enlightenhome.image.model.Image;

public interface IImageDao {
	
	public List<Image> getPropertyDetails(List<Image> imageList);

}
