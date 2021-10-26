package com.descuentos.springboot.app.usuarios.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.descuentos.springboot.app.usuarios.models.entity.Cupon;

public interface CuponDao extends CrudRepository <Cupon, Long> {

}
