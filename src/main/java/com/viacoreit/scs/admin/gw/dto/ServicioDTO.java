package com.viacoreit.scs.admin.gw.dto;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ServicioDTO {

    Long id;

    @NotBlank
    private String nombre;

    private Boolean deleted;
    private boolean active;


}
