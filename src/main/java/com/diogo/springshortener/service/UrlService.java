package com.diogo.springshortener.service;

import java.util.List;

import com.diogo.springshortener.model.Url;

public interface UrlService {
	
	public List<Url> searchAll();
	public Url insert(Url url);
	public Url update(Url url);
	public void delete(String urlId);
	
}
