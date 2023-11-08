package com.example.crudapplication.rest;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "blogPost", path = "blogPost")
public interface blogPostRepository extends MongoRepository<blogPost, String> {
	List<blogPost> findByBody(@Param("post")String post);

}
