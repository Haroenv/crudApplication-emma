package com.example.crudapplication.rest;

import org.springframework.data.annotation.Id;

public class blogPost {

	@Id
	private String id;

	private String title;
	private String body;

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
}
