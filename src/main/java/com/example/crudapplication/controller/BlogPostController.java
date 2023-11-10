package com.example.crudapplication.controller;

import com.example.crudapplication.model.BlogPost;
import com.example.crudapplication.repository.BlogPostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BlogPostController {
	@Autowired
	BlogPostRepository blogPostRepository;

	@GetMapping("/blog-posts")
	public ResponseEntity<List<BlogPost>> getAllBlogPosts(@RequestParam(required = false) String title) { }

	@GetMapping("/blog-posts/{id}")
	public ResponseEntity<BlogPost> getBlogPostById(@PathVariable("id") String id) { }

	@PostMapping("/blog-posts")
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) { }

	@PutMapping("/blog-posts/{id}")
	public ResponseEntity<BlogPost> updateBlogPost(@PathVariable("id") String id, @RequestBody BlogPost blogPost) { }

	@DeleteMapping("/blog-posts/{id}")
	public ResponseEntity<HttpStatus> deleteBlogPost(@PathVariable("id") String id) { }

	@DeleteMapping("/blog-posts")
	public ResponseEntity<HttpStatus> deleteAllBlogPosts() { }

	@GetMapping("/blog-posts/published")
	public ResponseEntity<List<BlogPost>> findByPublished() { }
}
