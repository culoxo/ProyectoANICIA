package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUDITORIA")
public class Auditoria implements Serializable {

	private static final long serialVersionUID = 4114643251792756139L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDITORIA_SEQ")
	@SequenceGenerator(name = "AUDITORIA_SEQ", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "ID_SERVICIO")
	private Long idServicio;

	@Column(name = "HORA")
	private Timestamp hora;

	@Column(name = "MENSAJE")
	private String mensaje;

	@Column(name = "IP_ORIGEN")
	private String ipOrigen;
	
	@Column(name = "XAPIKEY")
	private String xApiKey;
	
	@Column(name = "TIPO_SERVICIO")
	private String tipoServicio;
	
	@Column(name = "VERSION_SERVICIO")
	private String versionServicio;

	@Column(name = "ID_PETICION")
	private String idPeticion;

	@Column(name = "URL_PETICION")
	private String urlPeticion;
	
	@Column(name = "FASE")
	private String fase;
	

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", insertable = false, updatable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "ID_SERVICIO", insertable = false, updatable = false)
	private Servicio servicio;

}
