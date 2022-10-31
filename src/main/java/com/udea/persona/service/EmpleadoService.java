package com.udea.persona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.udea.persona.dao.IEmpleadoDAO;
import com.udea.persona.model.Empleado;;

@Service
public class EmpleadoService {

  @Autowired
  private IEmpleadoDAO empleadoDAO;

  public Empleado save(Empleado empleado) {
    return empleadoDAO.save(empleado);
  }

  public Empleado update(Empleado empleado) {
    return empleadoDAO.save(empleado);
  }

  public void delete(Long id) {
    empleadoDAO.deleteById(id);
  }

  public Iterable<Empleado> list() {
    return empleadoDAO.findAll();
  }

  public Optional<Empleado> listId(Long id) {
    return empleadoDAO.findById(id);
  }

  public Optional<Empleado> listCedula(Long cedula) {
    return empleadoDAO.getByCedula(cedula);
  }

  public void deleteCedula(Long cedula) {
    empleadoDAO.deleteByCedula(cedula);
  }

}