package com.rak.scheduler.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CALENDAR_CONSTRAINT")
public class CalendarConstraint extends AbstractAuditedEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1829172610559877481L;
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	private User owner;
	
	private Date start;
	private Date end;
	private double cost;
	
	public CalendarConstraint(CalendarConstraint constraint) {
		new CalendarConstraint(constraint.getId(), constraint.getOwner(), constraint.getStart(), constraint.getEnd(), constraint.getCost());
	}

	public CalendarConstraint(Long id, User owner, Date start, Date end, double cost) {
		super();
		this.id = id;
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	public CalendarConstraint() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
