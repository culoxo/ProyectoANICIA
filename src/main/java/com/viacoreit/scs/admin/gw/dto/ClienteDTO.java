package com.viacoreit.scs.admin.gw.dto;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.viacoreit.scs.admin.gw.entity.Servicio;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ClienteDTO {
	
    Long id;
    
	@NotBlank
    private String nombre;

    private String direccion;
    private String email;
    private String telefono;    
    private Boolean deleted;
    private Boolean active;

    private List <Servicio> servicios;
}
