package com.descuentos.springboot.app.usuarios.models.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.descuentos.springboot.app.usuarios.models.dao.UsuarioDao;
import com.descuentos.springboot.app.usuarios.models.entity.Usuario;

class UsuarioServiceImplTest {
	
	@InjectMocks
	UsuarioServiceImpl UsuarioService;
	
	@Mock
	UsuarioDao usuarioDao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindAll() {

		List<Usuario> usuarios = new ArrayList();
		Usuario usuario = new Usuario();
		usuario.setNombre("Pedro Navajas");
		usuarios.add(usuario);
		
		when(usuarioDao.findAll()).thenReturn(usuarios);
		
		List<Usuario> usuariosMocked = UsuarioService.findAll();
		assertEquals("Pedro Navajas", usuariosMocked.get(0).getNombre());
	}

}
