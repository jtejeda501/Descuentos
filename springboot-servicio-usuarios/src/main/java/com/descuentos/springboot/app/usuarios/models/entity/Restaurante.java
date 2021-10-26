package com.descuentos.springboot.app.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="to_restaurantes")
public class Restaurante implements Serializable {	

	private Integer id;
	
	private String nombre;
	
	private String rfc;
	
	private List<Cupon> cuponList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="nombre", length=80, nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="rfc", length=80, nullable=false)
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	@OneToMany(mappedBy="restaurante")
	public List<Cupon> getCuponList() {
		return cuponList;
	}

	public void setCuponList(List<Cupon> cuponList) {
		this.cuponList = cuponList;
	}

	private static final long serialVersionUID = -4887399308036190999L;


}
