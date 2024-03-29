package com.diogo.springshortener.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.diogo.springshortener.model.Url;
import com.diogo.springshortener.service.UrlService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UrlController {
	
	@Autowired
	private UrlService service;
		
	
	@GetMapping()
	public List<Url> findAll() {
		List<Url> list = new ArrayList<>();
		service.searchAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	@GetMapping("/{id}")
	public Url findById(@PathVariable Long id) {
		return service.search(id);
	}
	
	@GetMapping("/url/{urlShortened}")
	public RedirectView redirect(@PathVariable String urlShortened) throws IOException {		
		String url = service.searchByUrlShortened(urlShortened);
		if(url != null)
			return new RedirectView(url);
		throw new IOException();
	}
	
	@PostMapping("/url")
	public Url saveUrl(@Valid @RequestBody Url url) {
		return service.insert(url);
	}
	
	@PutMapping(value = "/url/{id}")
	public ResponseEntity<Url> updateUrl(@Valid @PathVariable Long id, @RequestBody Url url) {
		return new ResponseEntity<>(service.update(id, url), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/url/{id}")
	public ResponseEntity<?> deleteUrl(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
