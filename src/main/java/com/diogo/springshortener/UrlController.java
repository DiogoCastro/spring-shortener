package com.diogo.springshortener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogo.springshortener.model.Url;
import com.diogo.springshortener.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {
	
	@Autowired
	private UrlService service;
	
	@GetMapping()
	public List<Url> findAll() {
		List<Url> list = new ArrayList<>();
		service.searchAll().iterator().forEachRemaining(list::add);
		return list;
	}
}
