package com.descuentos.springboot.app.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="to_usuarios")
public class Usuario implements Serializable {

	private Long id;
	
	private String nombre;
	
	private String correo;
	
	private String psswrd;
	
	private Long referencia;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre", length=80, nullable=false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="correo", length=80, nullable=false)
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//@OneToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn(name="id")
	@Column(name="referencia_usuario", nullable=true)
	public Long getReferencia() {
		return referencia;
	}
	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}
	
	@Column(name="psswrd", length=45, nullable=false)
	public String getPsswrd() {
		return psswrd;
	}
	public void setPsswrd(String password) {
		this.psswrd = password;
	}

	private static final long serialVersionUID = 584701400158477556L;
	

}
