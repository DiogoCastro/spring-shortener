package com.diogo.springshortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.springshortener.model.Url;
import com.diogo.springshortener.repository.UrlRepository;

@Service(value = "urlService")
public class UrlServiceImpl implements UrlService{
	
	@Autowired
	UrlRepository urlRepo;

	@Override
	public List<Url> searchAll() {
		return urlRepo.findByActive(true);
	}
	
	@Override
	public String searchByUrlShortened(String urlShortened) {
		Url url = new Url();
		List<Url> list = this.urlRepo.findByUrlShortened(urlShortened);
		
		if (list.size() > 0) {
			url = list.get(0);
		} else {
			return "ERROR: Could not access this addres";
		}
		
		this.urlRepo.save(url);
		
		return url.getUrl();
	}

	@Override
	public Url insert(Url url) {
		url.setActive(true);
		Url response = urlRepo.save(url);
		return response;
	}

	@Override
	public Url update(Long id, Url url) {
		Url urlUpdate = urlRepo.getOne(id);
		urlUpdate.setUrl(url.getUrl());
		return urlRepo.save(urlUpdate);
	}

	@Override
	public void delete(Long id) {
		Url url = urlRepo.getOne(id);
		url.setActive(false);
		urlRepo.save(url);
	}

}
