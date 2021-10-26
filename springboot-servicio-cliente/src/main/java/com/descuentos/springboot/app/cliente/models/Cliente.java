package com.descuentos.springboot.app.cliente.models;


public class Cliente {

	private Usuario usuario;

	public Cliente() {}

	public Cliente(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
