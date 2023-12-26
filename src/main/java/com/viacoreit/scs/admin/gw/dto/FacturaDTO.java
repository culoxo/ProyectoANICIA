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
public class FacturaDTO {
	
    Long id;
    
    private Boolean deleted;
    private Boolean estado;

    //private List <Servicio> servicios;
}