package com.example.theatremanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  //specifies that java class is mapped to database table.
@Table(name="theatre")  //specifies that particular table is mapped.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Theatre {

	@Id //specifies that primary key of an entity.
	@GeneratedValue(generator = "theatreseq", strategy = GenerationType.IDENTITY) //specifies that provides a strategies to primary key keys.
	@SequenceGenerator(name="theatreseq",initialValue = 1)
	private int theatreId;
	
	@NonNull
	@Column(name = "theatre_name") //using this annotation we can add column in particular table.
	private String theatreName;
	
	@NotNull
	@Column(name = "total_screens")
	private int totalScreens;

	
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "theatre") //means that many rows in a table is mapped to one row in other table.
	//@JsonIgnore
	private List<Screen> screen;
	
	
	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getTotalScreens() {
		return totalScreens;
	}

	public void setTotalScreens(int totalScreens) {
		this.totalScreens = totalScreens;
	}

	public List<Screen> getScreens() {
		return screen;
	}

	public void setScreens(List<Screen> screen) {
		this.screen = screen;
	}

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(int theatreId, String theatreName, @NotNull int totalScreens, List<Screen> screen) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.totalScreens = totalScreens;
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", totalScreens=" + totalScreens
				+ ", screens=" + screen + "]";
	}

	

	

	
	
	
}
	