package com.diogo.springshortener.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="URL")
public class Url implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "URL_CD_ID")
	private Long id;
	
	@Column(name = "URL_TX_ADDRESS")
	private String address;
	
	@Column(name = "URL_TX_SHORTNED")
	private String urlShortned;
	
	boolean active;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return address;
	}
	
	public void setUrl(String address) {
		this.address = address;
	}
	
	public String getUrlShortned() {
		return urlShortned;
	}

	public void setUrlShortned(String urlShortned) {
		this.urlShortned = urlShortned;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}