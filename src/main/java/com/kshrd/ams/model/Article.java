package com.kshrd.ams.model;

public class Article {
	private int id;
	private String name;
	private String description;
	private String author;
	private String createdDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public Article() {}

	public Article(int id, String name, String description, String author, String createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author
				+ ", createdDate=" + createdDate + "]";
	}

}
