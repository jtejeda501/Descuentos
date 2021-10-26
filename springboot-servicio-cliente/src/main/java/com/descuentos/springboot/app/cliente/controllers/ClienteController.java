package com.descuentos.springboot.app.cliente.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.descuentos.springboot.app.cliente.models.Cliente;
import com.descuentos.springboot.app.cliente.models.Usuario;
import com.descuentos.springboot.app.cliente.models.service.IClienteService;

@RestController
public class ClienteController {
	
	private static Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Cliente detalle(@PathVariable Long id) {
		return clienteService.findById(id);
	}	
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario servicio) {
		return clienteService.save(servicio);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id) {
		return clienteService.update(usuario, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		clienteService.delete(id);
	}
}
