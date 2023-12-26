package com.viacoreit.scs.admin.gw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
@ToString
@Setter
@Getter
@Entity
@Table(name = "note")
@SQLDelete(sql = "UPDATE patient_file_note SET deleted = true WHERE pfn_id=?")
@Where(clause = "deleted=false")
public class Note extends Auditable<String> implements Serializable {


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -2819767021956804639L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Long id;

    @Column(name = "n_content")
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "n_patient_file_id")
//    private PatientFile patientFile;
    
    @Column(name = "n_module")
    private String module;

    private boolean deleted = Boolean.FALSE;

}*/
