package com.diogo.springshortener.service;

import java.util.List;

import com.diogo.springshortener.model.Url;

public interface UrlService {
	
	public List<Url> searchAll();
	public Url search(Long id);
	public String searchByUrlShortened(String shortenedUrl);
	public Url insert(Url url);
	public Url update(Long urlId, Url url);
	public void delete(Long urlId);
}
