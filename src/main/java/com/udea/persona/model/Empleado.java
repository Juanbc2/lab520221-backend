package com.udea.persona.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Empleado
 * 
 * @author Vanessa
 */
@ApiModel(description = "Todos los detalles del empledo. ")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Empleado implements Serializable {

  @ApiModelProperty(notes = "La base de datos genera el ID del empleado")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @ApiModelProperty(notes = "Cedula")
  @Column(name = "cedula", unique = true)
  private Long cedula;

  @ApiModelProperty(notes = "Nombre")
  @Column(name = "nombre")
  private String nombre;

  @ApiModelProperty(notes = "Apellido")
  @Column(name = "apellido")
  private String apellido;

  @ApiModelProperty(notes = "Correo")
  @Column(name = "correo")
  private String correo;

  @ApiModelProperty(notes = "Cargo")
  @Column(name = "cargo")
  private String cargo;

  @ApiModelProperty(notes = "Salario")
  @Column(name = "salario")
  private Long salario;

  @ApiModelProperty(notes = "Direccion")
  @Column(name = "direccion")
  private String direccion;

  @ApiModelProperty(notes = "Oficina")
  @Column(name = "oficina")
  private String oficina;

  @ApiModelProperty(notes = "Dependencia")
  @Column(name = "dependencia")
  private String dependencia;

  @ApiModelProperty(notes = "Fecha de ingreso")
  @Temporal(TemporalType.DATE)
  @Column(name = "fechaIngreso")
  private @NonNull Date fechaIngreso;

  @ApiModelProperty(notes = "Pago por Antiguedad")
  @Column(name = "pagoAntiguedad")
  private int pagoAntiguedad;

}
