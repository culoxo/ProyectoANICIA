package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIOS", schema = "GATEWAYSERVICIOS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "USUARIOS_SEQ", schema = "GATEWAYSERVICIOS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOS_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Long usuarioId;

	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "SURNAME2")
	private String surname2;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;
		
	@Column(name = "DELETED")
	private Boolean deleted = false;
	
	@Column(name = "ACTIVE")
	private Boolean active= true;

	@Column(name = "PREGUNTASEG")
	private String preguntaSeg;
	
	@Column(name = "RESPUESTASEG")
	private String respuestaSeg;

	@Column(name = "ADMIN")
	private Boolean admin = false;


}