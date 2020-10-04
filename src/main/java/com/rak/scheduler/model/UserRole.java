package com.rak.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole extends AbstractAuditedEntity {

	//ADMIN(0), PROVIDER(1), CLIENT(2);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5470322500853431992L;
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  	
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
