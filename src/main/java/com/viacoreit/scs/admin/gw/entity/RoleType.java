package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleType implements Serializable {

    @Id
    private Long id;

    private String code;
    private String description;

}