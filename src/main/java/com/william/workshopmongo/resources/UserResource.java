package com.william.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.william.workshopmongo.domain.User;
import com.william.workshopmongo.dto.UserDTO;
import com.william.workshopmongo.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//@GetMapping Existe também esta notação, que o resultado será o mesmo que a debaixo
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){				
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
