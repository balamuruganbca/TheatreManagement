package com.example.theatremanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  //specifies that java class is mapped to database table.
@Table(name="seats") //this annotation specifies that particular table is mapped.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Seat
{
	@Id  //specifies that primary key  of an entity.
	@Column(name = "seat_id") //specifies that add a column in particular table.
	@GeneratedValue(generator = "saetseq", strategy = GenerationType.IDENTITY)  //provides for the specification of generation strategies for the values of primary keys.
	@SequenceGenerator(name="seatseq",initialValue = 500)
	private int seatId;
	
	
	@NotNull
	@Column(name = "is_booked")
	Boolean isBooked = false;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY) //means that many rows in one table is mapped to one row in another table.
	@JoinColumn(name= "screen_id")  //used to specify a column that joining a association of an entity.
	private Screen screen;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Seat(int seatId, @NotNull Boolean isBooked, Screen screen) {
		super();
		this.seatId = seatId;
		this.isBooked = isBooked;
		this.screen = screen;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", isBooked=" + isBooked + ", screen=" + screen + "]";
	}

	

	

	

	
	
	
	
	
}