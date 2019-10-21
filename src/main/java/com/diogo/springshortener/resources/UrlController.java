package com.diogo.springshortener.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.diogo.springshortener.model.Url;
import com.diogo.springshortener.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
	
	@Autowired
	private UrlService service;
		
	
	@GetMapping("/urls")
	public List<Url> findAll() {
		List<Url> list = new ArrayList<>();
		service.searchAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
//	@GetMapping("/url/{urlShortened}")
//	public String redirect (@PathVariable String urlShortened) {
//		return service.searchByUrlShortened(urlShortened);
//	}
	
	@GetMapping("/url/{urlShortened}")
	public RedirectView redirect(@PathVariable String urlShortened) throws IOException {		
		String url = service.searchByUrlShortened(urlShortened);
		if(url != null)
			return new RedirectView(url);
		throw new IOException();
	}
	
	@PostMapping("/url")
	public Url saveUrl(@RequestBody Url url) {
		return service.insert(url);
	}
	
	@DeleteMapping(value = "/url/{id}")
	public ResponseEntity<?> deleteUrl(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
