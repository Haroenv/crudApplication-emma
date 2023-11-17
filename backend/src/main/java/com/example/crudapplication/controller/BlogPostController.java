package com.example.crudapplication.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.crudapplication.model.BlogPost;
import com.example.crudapplication.repository.BlogPostRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BlogPostController {
	@Autowired
	BlogPostRepository blogPostRepository;

	@GetMapping("/blog-posts")
	public ResponseEntity<List<BlogPost>> getAllBlogPosts(@RequestParam(required = false) String title) {
		try {
			List<BlogPost> blogPosts = new ArrayList<BlogPost>();

			if (title == null)
				blogPostRepository.findAll().forEach(blogPosts::add);
			else
				blogPostRepository.findByTitleContaining(title).forEach(blogPosts::add);

			if (blogPosts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(blogPosts, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/blog-posts/{id}")
	public ResponseEntity<BlogPost> getBlogPostById(@PathVariable("id") String id) {
		Optional<BlogPost> blogPostData = blogPostRepository.findById(id);

		if (blogPostData.isPresent()) {
			return new ResponseEntity<>(blogPostData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/blog-posts")
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
		try {
			BlogPost _blogPost = blogPostRepository.save(new BlogPost(
				blogPost.getTitle(),
				blogPost.getBody(),
				false));
			return new ResponseEntity<>(_blogPost, HttpStatus.CREATED);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/blog-posts/{id}")
	public ResponseEntity<BlogPost> updateBlogPost(@PathVariable("id") String id, @RequestBody BlogPost blogPost) {
		Optional<BlogPost> blogPostData = blogPostRepository.findById(id);

		if (blogPostData.isPresent()) {
			BlogPost _blogPost = blogPostData.get();
			_blogPost.setTitle(blogPost.getTitle());
			_blogPost.setBody(blogPost.getBody());
			_blogPost.setPublished(blogPost.isPublished());
			return new ResponseEntity<>(blogPostRepository.save(_blogPost), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/blog-posts/{id}")
	public ResponseEntity<HttpStatus> deleteBlogPost(@PathVariable("id") String id) {
		try {
			blogPostRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/blog-posts")
	public ResponseEntity<HttpStatus> deleteAllBlogPosts() {
		try {
			blogPostRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/blog-posts/published")
	public ResponseEntity<List<BlogPost>> findByPublished() {
		try {
			List<BlogPost> blogPosts = blogPostRepository.findByPublished(true);

			if (blogPosts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(blogPosts, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
