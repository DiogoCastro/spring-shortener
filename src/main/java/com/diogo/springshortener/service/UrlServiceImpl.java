//package com.diogo.springshortener.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.diogo.springshortener.model.Url;
//import com.diogo.springshortener.repository.UrlRepository;
//
//@Service(value = "urlService")
//public class UrlServiceImpl implements UrlService{
//	
//	@Autowired
//	UrlRepository urlRepo;
//
//	@Override
//	public List<Url> searchAll() {
//		return urlRepo.findAll();
//	}
//
//	@Override
//	public Url insert(Url url) {
//		Url response = urlRepo.insert(url);
//		return response;
//	}
//
//	@Override
//	public Url update(Url url) {
//		Url response = urlRepo.save(url);
//		return response;
//	}
//
//	@Override
//	public void delete(@PathVariable String urlId) {
//		urlRepo.deleteById(urlId);
//	}
//
//}
