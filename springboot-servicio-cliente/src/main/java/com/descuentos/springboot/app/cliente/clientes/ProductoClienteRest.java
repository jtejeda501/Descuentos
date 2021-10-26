package com.descuentos.springboot.app.cliente.clientes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.descuentos.springboot.app.cliente.models.Usuario;

public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Usuario> listar();
	
	@GetMapping("/ver/{id}")
	public Usuario detalle(@PathVariable Long id);
	
	@PostMapping("/crear")
	public Usuario crear(@RequestBody Usuario producto);
	
	@PutMapping("/editar/{id}")
	public Usuario update(@RequestBody Usuario producto, @PathVariable Long id);
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id);

}
