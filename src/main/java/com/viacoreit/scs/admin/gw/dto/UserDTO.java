package com.viacoreit.scs.admin.gw.dto;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
public class UserDTO {

	
    private Long id;
	
	@NotBlank
    private String username;

	@NotBlank
	private String name;

	private String surname;
	private String surname2;
	private String email;

	@NotBlank
	private String password;
	
	private Boolean admin = false;
	private Boolean deleted = false;
	private Boolean active;
	private String preguntaSeg;
	private String respuestaSeg;
}