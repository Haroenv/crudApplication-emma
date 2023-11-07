package com.example.crudapplication;

import com.example.crudapplication.blogPost.BlogPost;
import com.example.crudapplication.blogPost.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class crudApplication implements CommandLineRunner {

	@Autowired
	private BlogPostRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(crudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new BlogPost("First post", "Hello world!"));
		repository.save(new BlogPost("How excited am I for Christmas?", "VERY"));
		repository.save(new BlogPost("What was the body of my first post?", "Hello world!"));

		System.out.println("Blog posts found with findAll():");
		System.out.println("--------------------------------");
		for (BlogPost blogPost : repository.findAll()) {
			System.out.println(blogPost);
		}
		System.out.println();

		System.out.println("Blog posts found with findByTitle('How excited am I for Christmas?'):");
		System.out.println("---------------------------------------------------------------------");
		System.out.println(repository.findByTitle("How excited am I for Christmas?"));

		System.out.println("Blog posts found with findByBody('Hello world!'):");
		System.out.println("-------------------------------------------------");
		for (BlogPost blogPost : repository.findByBody("Hello world!")) {
			System.out.println(blogPost);
		}
	}
}
