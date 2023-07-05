package com.api.apiRestJava.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiRestJava.models.UsuarioModel;
import com.api.apiRestJava.services.UsuarioService;

@RestController
@RequestMapping("/user")

public class UsuarioController {
	
	private static final String UsuarioService = null;
	@Autowired
	private UsuarioService userService;
	@GetMapping
	public ArrayList<UsuarioModel> getUsuarios(){
		return this.userService.getUsuarios();
	}
	
	@PostMapping
	public UsuarioModel saveUser(@RequestBody UsuarioModel user)
	{
		return this.userService.saveUser(user);
		
	}
	//cambiar el path
	@GetMapping (path = "/{id}")
	public Optional <UsuarioModel> getUserById(@PathVariable Integer id)
	{
		return this.userService.getById(id);
	}
	
	@PutMapping(path = "/{id}")
	public UsuarioModel updateUserById(@RequestBody UsuarioModel request,@PathVariable Integer id)
	
	{
		return this.userService.updateById(request, id);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public UsuarioModel deleteById(@PathVariable("id") Integer id) {
		boolean ok = this.userService.deleteUser(id);
		if(ok) {
			return "user whit id:" + id + "deleted";
			
		}else {
			return "error";
			
		} 
	}
		
	
	
}
