package com.example.theatremanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  //specifies that java class is mapped to database table.
@Table(name="screen") //with the help of this property name is specifies with particular table is mapped to.
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Screen 
{
	@Id  //specifies that primary key  of an entity
	@GeneratedValue(generator = "screenseq", strategy = GenerationType.IDENTITY)  //provides for the specification of generation strategies for the values of primary keys.
	@SequenceGenerator(name="screenseq",initialValue = 300)
	@Column(name = "screen_id")  //used for Adding the column the name in the table of a particular MySQL database.
	private int screenId;
	
	@NotNull
	@Column(name = "screen_name")
	private String screenName;
	
	@NotNull
	@Column(name="total_no_of_seats")
	private int totalNoOfSeats;
	
	@OneToMany(mappedBy = "screen",fetch = FetchType.LAZY)
	private List<Seat> seats;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY) //means that many rows in a table is mapped to one row in other table.
	//@JsonIgnore
	@JoinColumn(name= "theatre_id") //used to specify a column for joining an entity association or element collection.
	private Theatre theatre;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getTotalNoOfSeats() {
		return totalNoOfSeats;
	}

	public void setTotalNoOfSeats(int totalNoOfSeats) {
		this.totalNoOfSeats = totalNoOfSeats;
	}

	
	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Screen(int screenId, @NotNull String screenName, @NotNull int totalNoOfSeats, List<Seat> seats,
			Theatre theatre) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.totalNoOfSeats = totalNoOfSeats;
		this.seats = seats;
		this.theatre = theatre;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", totalNoOfSeats=" + totalNoOfSeats
				+ ", seats=" + seats + ", theatre=" + theatre + "]";
	}

	
}