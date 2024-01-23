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

    private List<Servicio> servicios;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClienteDTO{id=").append(id)
                .append(", nombre='").append(nombre).append('\'')
                .append(", direccion='").append(direccion).append('\'')
                .append(", email='").append(email).append('\'')
                .append(", telefono='").append(telefono).append('\'')
                .append(", deleted=").append(deleted)
                .append(", active=").append(active)
                .append(", servicios=").append(servicios)
                .append('}');
        return stringBuilder.toString();
    }
}
