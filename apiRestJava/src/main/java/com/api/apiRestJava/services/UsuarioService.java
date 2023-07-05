package com.api.apiRestJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestJava.models.UsuarioModel;
import com.api.apiRestJava.repositories.IUsuarioRepository;
import java.util.*;

@Service
public class UsuarioService {
	
	@Autowired
	IUsuarioRepository userRepository;
	
	public ArrayList<UsuarioModel> getUsuarios(){
		return (ArrayList<UsuarioModel>) userRepository.findAll();
		
	}
	public UsuarioModel saveUser(UsuarioModel user)
	{
		return userRepository.save(user);
	}
	
	
	//Metodo, obtener el usuario por id, optional hace puede devolver un tipo o null
	public Optional<UsuarioModel> getById(Integer id)
	{
		return this.userRepository.findById(id);
	}
	
	public Optional<UsuarioModel> updateById(UsuarioModel request, Integer id)
	{
		UsuarioModel userModel = userRepository.findById(id).get();
		userModel.setNombre(request.getNombre());
		userModel.setPassword(request.getPassword());
		userModel.setEmail(request.getEmail());
		userRepository.save(userModel);
		return userModel;
	}
	
	public Boolean deleteUser (Integer id)
	{
		try {
			userRepository.deleteById(id);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
	
}
