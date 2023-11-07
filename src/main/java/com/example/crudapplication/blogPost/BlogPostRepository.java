package com.example.crudapplication.blogPost;

import com.example.crudapplication.blogPost.BlogPost;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
	public BlogPost findByTitle(String title);
	public List<BlogPost> findByBody(String body);

}
