package com.diogo.springshortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diogo.springshortener.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	List<Url> findByActive(Boolean active);
	List<Url> findByUrlShortened(String url_encurtada);
}
