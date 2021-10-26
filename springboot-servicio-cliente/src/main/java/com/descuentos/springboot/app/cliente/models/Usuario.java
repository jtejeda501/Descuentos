package com.descuentos.springboot.app.cliente.models;


public class Usuario {
	
	private Long id;	
	private String nombre;	
	private String correo;	
	private String psswrd;	
	private Long referencia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPsswrd() {
		return psswrd;
	}
	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}
	public Long getReferencia() {
		return referencia;
	}
	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}
	
	
	

}
