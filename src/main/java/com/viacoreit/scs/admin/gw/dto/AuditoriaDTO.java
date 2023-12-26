package com.viacoreit.scs.admin.gw.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.viacoreit.scs.admin.gw.entity.Cliente;
import com.viacoreit.scs.admin.gw.entity.Servicio;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AuditoriaDTO {

    Long id;
	
	private Long idCliente;
	private Long idServicio;
	private Timestamp hora;
    private String mensaje;
	private String fase;
	private Cliente cliente;
	private Servicio servicio;

}
