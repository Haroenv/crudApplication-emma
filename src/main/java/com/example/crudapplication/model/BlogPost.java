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

//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getBody() {
//		return body;
//	}
//
//	public void setBody(String body) {
//		this.body = body;
//	}
}
