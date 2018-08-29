package com.tcs.hack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id")
    @SequenceGenerator(sequenceName = "booking_id", allocationSize = 1, name = "booking_id")
	@Column(name="booking_id",nullable=false)
	private int bookingId;
	
	public Booking(Date bookingDate, String bookingSlot, Resource resource) {
		super();
		this.bookingDate = bookingDate;
		this.bookingSlot = bookingSlot;
		this.resource = resource;
	}
	
	public Booking() {
		super();
	}
	
	@Column(name="booking_date",nullable=false)
	private Date bookingDate;
	
	@Column(name="booking_slot",nullable=false)
	private String bookingSlot;
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="resource_id")
	private Resource resource;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingSlot() {
		return bookingSlot;
	}
	public void setBookingSlot(String bookingSlot) {
		this.bookingSlot = bookingSlot;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Date getBookingDate() {
		return (Date) bookingDate.clone();
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate!=null?(Date) bookingDate.clone():null;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingSlot=" + bookingSlot + ", resource=" + resource + "]";
	}
	
	
	
	
}