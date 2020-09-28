package com.rak.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole extends AbstractAuditedEntity {

	//ADMIN(0), PROVIDER(1), CLIENT(2);
	
	private Long id;
	private String roleName;
	

	public UserRole(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
