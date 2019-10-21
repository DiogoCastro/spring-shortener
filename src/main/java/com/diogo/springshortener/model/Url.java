package com.diogo.springshortener.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.diogo.springshortener.commom.Converter;


@Entity
@Table(name="TB_URL")
public class Url implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String url;
	
	private String urlShortened;
	
	@NotNull
	private Boolean active;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		if (!url.contains("://")) {
			this.url = "http://" + url;
		} else
			this.url = url;
	}
	
	public String getUrlShortened() {
		return urlShortened;
	}
	
	public void setUrlShortened(String urlShortened) {
		Converter converter = new Converter();
		if (urlShortened.isEmpty()) {
			this.urlShortened = converter.getGenerateName(6);
		} else 
			this.urlShortened = urlShortened;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
}