package com.william.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.william.workshopmongo.domain.User;
import com.william.workshopmongo.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//@GetMapping Existe também esta notação, que o resultado será o mesmo que a debaixo
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){				
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
}
