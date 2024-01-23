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
@Table(name = "FACTURA", schema = "GATEWAYSERVICIOS")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FACTURA_SEQ", schema = "GATEWAYSERVICIOS" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURA_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Long facturaId;

	@Column(name = "ESTADO")
	private boolean estado = true;

    @Column(name = "DELETED")
	private boolean deleted = false;


}

