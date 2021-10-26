package com.descuentos.springboot.app.usuarios.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.descuentos.springboot.app.usuarios.models.entity.Usuario;

@Service
public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
}
