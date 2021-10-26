package com.descuentos.springboot.app.cliente.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.descuentos.springboot.app.cliente.models.Cliente;
import com.descuentos.springboot.app.cliente.models.Usuario;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Cliente> findAll() {
		List<Usuario> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8080/listar", Usuario[].class));
		
		return productos.stream().map(p -> new Cliente(p)).collect(Collectors.toList());
	}

	@Override
	public Cliente findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Usuario usuario = clienteRest.getForObject("http://localhost:8080/ver/{id}", Usuario.class, pathVariables);
		return new Cliente(usuario);
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		HttpEntity<Usuario> body = new HttpEntity<Usuario>(usuario);
		
		ResponseEntity<Usuario> response = clienteRest.exchange("http://localhost:8080/crear", HttpMethod.POST, body, Usuario.class);
		Usuario usuarioResponse = response.getBody();
		return usuarioResponse;
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		HttpEntity<Usuario> body= new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> response = clienteRest.exchange("http://localhost:8080/editar/{id}", 
				HttpMethod.PUT, body, Usuario.class, pathVariables);
		
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		clienteRest.delete("http://localhost:8080/eliminar/{id}", pathVariables);
		
	}

}
