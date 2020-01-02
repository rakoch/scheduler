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
	private long id;
    
    @ManyToOne(cascade=CascadeType.ALL) 
	private User owner;
	private Date start;
	private Date end;
	private double cost;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "APPOINTMENT_USER", 
			joinColumns = { @JoinColumn(name = "APPOINTMENT_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID") }
			)
	private Set<User> participants;
	private String description;
	private String title;
   
    public long getId()  
    {  
        return id;  
    }  
    public void setId(long id)  
    {  
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
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
