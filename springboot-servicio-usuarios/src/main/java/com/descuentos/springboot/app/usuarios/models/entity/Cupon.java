package com.descuentos.springboot.app.usuarios.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="to_cupones")
public class Cupon implements Serializable{

	private Long id;	
	private String descripcion;
	private Restaurante restaurante;		
	private Date caducidad;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="descripcion", nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name="fecha_caducidad", nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date createAt) {
		this.caducidad = createAt;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurante", nullable=false)
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	private static final long serialVersionUID = 1285454306356845809L;

}
