package com.adan.winelist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wines")
public class WineReview {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="score")
	private int score;
	
	@Column(name="year")
	private int year;
	
	@Column(name="message")
	private String message;
	
	@Column(nullable = true, length = 64)
	private String picture;

	public WineReview( String name, String type, int score, int year,String message, String picture) {
		this.year=year;
		this.name = name;
		this.type = type;
		this.score = score;
		this.message = message;
		this.picture = picture;
	}
	
	public WineReview() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "WineReview [id=" + id + ", name=" + name + ", type=" + type + ", score=" + score + ", year=" + year
				+ ", message=" + message + ", picture=" + picture + "]";
	}


	
	
}
