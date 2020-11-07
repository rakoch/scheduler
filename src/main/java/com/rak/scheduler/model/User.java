package com.rak.scheduler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "USER")
public class User extends AbstractAuditedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5717552275460680234L;
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	
	//@Enumerated(EnumType.STRING) TODO use enum or not
	@ElementCollection(targetClass = Role.class)
	@CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "roles", nullable = false)
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")  
	private Set<AvailableSlot> availableSlots = new HashSet<AvailableSlot>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private Set<Appointment> appointments = new HashSet<Appointment>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<AvailableSlot> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(Set<AvailableSlot> availableSlots) {
		this.availableSlots = availableSlots;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
}
