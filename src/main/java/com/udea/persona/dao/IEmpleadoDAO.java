package com.udea.persona.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udea.persona.model.Empleado;

/**
 * IEmpleadoDAO
 * 
 * @author Vanessa
 */
public interface IEmpleadoDAO extends CrudRepository<Empleado, Long> {
    public void deleteByCedula(Long cedula);
    public Optional<Empleado> getByCedula(Long cedula);
}
