package com.example.crudapplication.blogPost;

import org.springframework.data.annotation.Id;

public class BlogPost {

	@Id
	public String id;

	public String title;
	public String body;

	public BlogPost() {}

	public BlogPost(String title, String body) {
		this.title = title;
		this.body = body;
	}

	@Override
	public String toString() {
		return String.format(
			"BlogPost[id=%s, title='%s', body='%s']",
			id, title, body);
	}

}
