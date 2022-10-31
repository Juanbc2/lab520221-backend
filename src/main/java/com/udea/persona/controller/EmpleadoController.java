package com.udea.persona.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.udea.persona.exception.ModelNotFoundException;
import com.udea.persona.model.Empleado;
import com.udea.persona.service.EmpleadoService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Empleado
 * 
 * @author Vanessa
 */
@RestController
@RequestMapping("/api/v1/empleados")
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "Sistema de Administración de Empleados", description = "Operaciones relativas al empleado en el Sistema de Gestión de Empleados")
public class EmpleadoController {

  @Autowired
  EmpleadoService empleadoService;

  @ApiOperation(value = "Crear empleado")
  @PutMapping("/save")
  public Empleado save(@ApiParam(value = "Empleado a crear", required = true) @RequestBody Empleado empleado) {
    return empleadoService.save(empleado);
  }

  @ApiOperation(value = "Actualizar empleado")
  @PostMapping("/update")
  public Empleado update(@ApiParam(value = "Empleado a actualizar", required = true) @RequestBody Empleado empleado) {
    return empleadoService.update(empleado);
  }

  @ApiOperation(value = "Eliminar empleado por cedula")
  @DeleteMapping("/deletebycedula/{cedula}")
  public void deleteCedula(
      @ApiParam(value = "Cedula del empleado a eliminar", required = true) @PathVariable("cedula") Long cedula) {
    empleadoService.deleteCedula(cedula);
  }

  @ApiOperation(value = "Eliminar empleado")
  @PostMapping("/delete/{id}")
  public void delete(@ApiParam(value = "Id del empleado a eliminar", required = true) @PathVariable("id") Long id) {
    empleadoService.delete(id);
  }

  @ApiOperation(value = "Ver lista de empleados", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Se ha encontrado la lista de empleados"),
      @ApiResponse(code = 401, message = "No estás autorizado para ver la lista de empleados"),
      @ApiResponse(code = 403, message = "Acceso a la lista de empleados prohibido"),
      @ApiResponse(code = 404, message = "No se ha encontrado la lista de empleados")
  })
  @GetMapping("/listAll")
  public List<Empleado> list() {
    return (List<Empleado>) empleadoService.list();
  }

  @ApiOperation(value = "Ver empleado por id", response = Empleado.class)
  @GetMapping("/list/{id}")
  public Optional<Empleado> listId(@ApiParam(value = "Id del empleado", required = true) @PathVariable("id") Long id) {
    if (empleadoService.listId(id).isPresent()) {
      return empleadoService.listId(id);
    } else {
      throw new ModelNotFoundException("No se ha encontrado el empleado con id: " + id);
    }
  }

  @ApiOperation(value = "Ver empleado por cedula", response = Empleado.class)
  @GetMapping("/listbycedula/{cedula}")
  public Optional<Empleado> listCedula(
      @ApiParam(value = "Cedula del empleado", required = true) @PathVariable("cedula") Long cedula) {
    if (empleadoService.listCedula(cedula).isPresent()) {
      return empleadoService.listCedula(cedula);
    } else {
      throw new ModelNotFoundException("No se ha encontrado el empleado con cedula: " + cedula);
    }
  }

}
