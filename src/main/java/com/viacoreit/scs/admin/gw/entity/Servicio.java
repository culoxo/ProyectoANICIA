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
@Table(name = "SERVICIO", schema = "GATEWAYSERVICIOS")
public class Servicio implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SERVICIO_SEQ", schema = "GATEWAYSERVICIOS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICIO_SEQ")
	@Column(name = "ID_SERVICIO", unique = true, nullable = false)
    private Long servicioId;

    @Column(name = "NOMBRE")
    private String nombre;
 
    @Column(name = "DELETED")
    private boolean deleted = false;
    
    @Column(name = "ACTIVE")
    private boolean active = true;

}
