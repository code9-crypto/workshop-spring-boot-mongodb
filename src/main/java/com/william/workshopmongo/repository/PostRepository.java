package com.william.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.william.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	//Criando uma consulta personalizada para o mongoDB por meio do spring data
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query( "{ 'title' : { $regex: ?0, $options: 'i' } }" )
	List<Post> findByTitle(String text);

}
