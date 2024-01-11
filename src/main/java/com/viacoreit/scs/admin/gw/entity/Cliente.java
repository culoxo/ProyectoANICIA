package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "CLIENTE", schema = "GATEWAYSERVICIOS")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLIENTE_SEQ", schema = "GATEWAYSERVICIOS" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	@Column(name = "ID_CLIENTE", unique = true, nullable = false)
	private Long clienteId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "DELETED")
	private boolean deleted = false;

	@Column(name = "ACTIVE")
	private boolean active = true;


	@JoinTable(name = "CLIENTE_SERVICIO", schema = "GATEWAYSERVICIOS",
	        joinColumns = @JoinColumn(name = "ID_CLIENTE", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="ID_SERVICIO", nullable = false))
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Servicio> servicios;


}
