package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SERVICIO_PROPIEDAD")
public class ServicioPropiedad implements Serializable{

    private static final long serialVersionUID = -6851477536448262778L;

	@Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_SERVICIO")
    private Long idServicio;
 
    @Column(name = "CLAVE")
    private String clave;
    
    @Column(name = "VALOR")
    private String valor;
    
    @Column(name = "UBICACION")
    private String ubicacion;
    

}

