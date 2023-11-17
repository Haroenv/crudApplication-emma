package com.example.crudapplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "blogPosts")
public class BlogPost {

	@Id
	private String id;

	private String title;
	private String body;
	private boolean published;

	public BlogPost() {

	}

	public BlogPost(String title, String body, boolean published) {
		this.title = title;
		this.body = body;
		this.published = published;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", body=" + body + ", published=" + published + "]";
	}
}
