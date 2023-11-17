package com.example.crudapplication.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.crudapplication.model.BlogPost;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
	List<BlogPost> findByPublished(boolean published);
	List<BlogPost> findByTitleContaining(String title);

}
