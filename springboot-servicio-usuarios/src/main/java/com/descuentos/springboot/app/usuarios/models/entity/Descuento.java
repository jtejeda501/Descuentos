package com.descuentos.springboot.app.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="to_descuentos")
public class Descuento implements Serializable{	
	
	private Long id;	
	private Cupon cupon;
	private Usuario usuario;
	private String activo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JoinColumn(name="cupon_id", nullable=false)
	@Column(name="cupon_id", nullable=false)
	public Cupon getCupon() {
		return cupon;
	}
	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}
	
	@JoinColumn(name="usuario_id", nullable=false)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Column(name="activo", nullable=false)
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	private static final long serialVersionUID = -6582403491843105169L;


}
