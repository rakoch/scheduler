package com.rak.scheduler.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment extends AbstractAuditedEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2663466529675539524L;
	
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	private Long id;
    
    @ManyToOne(cascade=CascadeType.ALL) 
	private User owner;
	private Date start;
	private Date end;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "APPOINTMENT_USER", 
			joinColumns = { @JoinColumn(name = "APPOINTMENT_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID") }
			)
	private Set<User> participants;
	private String title;
	private String description;

	private Double cost;
	
	
	public Appointment(Long id, User owner, Date start, Date end, Double cost, Set<User> participants, String title,
			String description) {
		super();
		this.id = id;
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.participants = participants;
		this.title = title;
		this.description = description;
		this.cost = cost;
	}

	public Appointment(AvailableSlot availableSlot, User owner, Set<User> participants, String title, String description) {
		super();
		this.owner = owner;
		this.start = availableSlot.getStart();
		this.end = availableSlot.getEnd();
		this.cost = availableSlot.getCost();
		this.participants = participants;
		this.description = description;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Set<User> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
	

}
