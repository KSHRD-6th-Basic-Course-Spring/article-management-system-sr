package com.kshrd.ams.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Article {

	@NotNull
	private int id;
	@NotBlank
	private String title;

	private Category category;

	@NotBlank
	private String description;

	private String thumbnail;

	@NotBlank
	@Size(min = 5, max = 10)
	private String author;
	private String createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public Article(int id, String title, Category category, String description, String thumbnail, String author,
			String createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.thumbnail = thumbnail;
		this.author = author;
		this.createdDate = createdDate;
	}

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", thumbnail=" + thumbnail + ", author=" + author + ", createdDate=" + createdDate + "]";
	}

}
