package com.descuentos.springboot.app.usuarios.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.descuentos.springboot.app.usuarios.exceptions.UsuarioServiceException;
import com.descuentos.springboot.app.usuarios.models.entity.Usuario;
import com.descuentos.springboot.app.usuarios.models.response.ErrorMessages;
import com.descuentos.springboot.app.usuarios.models.service.IUsuarioService;


@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return usuarioService.findAll().stream().map(usuario ->{
			return usuario;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Usuario detalle(@PathVariable Long id) {
		Usuario producto = usuarioService.findById(id);	
		return producto;
	}
	
		
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) throws UsuarioServiceException {
		List<Usuario> usuarios = usuarioService.findAll().stream().map(user ->{
			return user;
		}).collect(Collectors.toList());
		
		usuarios.forEach(v ->{
			if(v.getCorreo().equalsIgnoreCase(usuario.getCorreo())) 
				throw new UsuarioServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
			
		});
		
		return usuarioService.save(usuario);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioDb = usuarioService.findById(id);
		
		usuarioDb.setNombre(usuario.getNombre());
		usuarioDb.setCorreo(usuario.getCorreo());
		usuarioDb.setReferencia(usuario.getReferencia());
		usuarioDb.setPsswrd(usuario.getPsswrd());
        
        return usuarioService.save(usuarioDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
	

}
