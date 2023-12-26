package com.viacoreit.scs.admin.gw.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAdminDto {

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname2() {
		return surname2;
	}
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public List<RoleDto> getRtList() {
		return rtList;
	}
	public void setRtList(List<RoleDto> rtList) {
		this.rtList = rtList;
	}
	public List<String> getUhcList() {
		return uhcList;
	}
	public void setUhcList(List<String> uhcList) {
		this.uhcList = uhcList;
	}
	private Long id;
    private String username;
    private Long role;
	private String name;
	private String surname;
	private String surname2;
	private String dni;
	private String email;
	private String phone;
	private Boolean active;
	private Date deletedAt;
	//private Set<Long> userRoles;
	private List<RoleDto> rtList;
	private List<String> uhcList;

}
