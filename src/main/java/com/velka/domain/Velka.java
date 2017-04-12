package com.velka.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Velka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String velka;
    private String info;
    
    public Velka() {
    } 

	public Velka(String velka, String info) {
		super(); 
		this.velka = velka;
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVelka() {
		return velka;
	}

	public void setVelka(String velka) {
		this.velka = velka;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Velka [id=" + id + ", velka=" + velka + ", info=" + info + "]";
	}

	
}
