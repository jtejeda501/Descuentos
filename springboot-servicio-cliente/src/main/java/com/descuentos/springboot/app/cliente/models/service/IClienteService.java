package com.descuentos.springboot.app.cliente.models.service;

import java.util.List;

import com.descuentos.springboot.app.cliente.models.Cliente;
import com.descuentos.springboot.app.cliente.models.Usuario;

public interface IClienteService {

	public List<Cliente> findAll();
	public Cliente findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public Usuario update(Usuario usuario, Long id);
	
	public void delete(Long id);
}
