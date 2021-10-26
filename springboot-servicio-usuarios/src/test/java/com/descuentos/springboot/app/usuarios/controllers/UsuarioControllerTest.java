package com.descuentos.springboot.app.usuarios.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.RequestBody;

import com.descuentos.springboot.app.usuarios.exceptions.UsuarioServiceException;
import com.descuentos.springboot.app.usuarios.models.entity.Usuario;
import com.descuentos.springboot.app.usuarios.models.service.IUsuarioService;

class UsuarioControllerTest {
	
	@InjectMocks
	UsuarioController usuarioController;
	
	@Mock
	IUsuarioService usuarioService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testListar() {
		
		List<Usuario> usuarios = new ArrayList();
		Usuario usuario = new Usuario();
		usuario.setNombre("Pedro Navajas");
		usuarios.add(usuario);
		
		when(usuarioService.findAll()).thenReturn(usuarios);
		
		List<Usuario> usuariosMocked = usuarioController.listar();
		assertEquals("Pedro Navajas", usuariosMocked.get(0).getNombre());
	}
	
	@Test 
	void testcrear() {
		
		List<Usuario> usuarios = new ArrayList();
		Usuario usuarioRegistrado = new Usuario();
		usuarioRegistrado.setNombre("Pedro Navajas");
		usuarioRegistrado.setCorreo("pepo@hotmail.com");
		usuarioRegistrado.setPsswrd("12344568");
		usuarios.add(usuarioRegistrado);
		
		when(usuarioService.findAll()).thenReturn(usuarios);
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Escutia");
		usuario.setCorreo("escujuan@hotmail.com");
		usuario.setPsswrd("hdwiu9");
		
	    usuarioController.crear(usuario);
	    
	    when(usuarioService.save(usuario)).thenReturn(usuario);
	    
	    assertEquals("Juan Escutia", usuario.getNombre());
	}
	
	@Test 
	void testcrear_UsuarioServiceException() {
		
		List<Usuario> usuarios = new ArrayList();
		Usuario usuarioRegistrado = new Usuario();
		usuarioRegistrado.setNombre("Pedro Navajas");
		usuarioRegistrado.setCorreo("pepo@hotmail.com");
		usuarioRegistrado.setPsswrd("12344568");
		usuarios.add(usuarioRegistrado);
		
		when(usuarioService.findAll()).thenReturn(usuarios);
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Menecez");
		usuario.setCorreo("pepo@hotmail.com");
		usuario.setPsswrd("kjdsi38");
		
	    	    
	    assertThrows(UsuarioServiceException.class,
	    		()->{
	    			usuarioController.crear(usuario);
	    		});
	    
	}

}
