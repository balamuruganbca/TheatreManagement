package com.example.theatremanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  //specifies that java class is mapped to the database table
@Table(name="movies")  //with the help of this property name is specifies with particular table is mapped to.
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Movie
{
	@Id  //specifies the primary key of an entity.
	@GeneratedValue(generator="movieseq" ,strategy=GenerationType.IDENTITY)  //provides for the specification of generation strategies for the values of primary keys.
	@SequenceGenerator(name="movieseq",initialValue = 100)
	//@NotNull
	@Column(name="id")  //used for Adding the column the name in the table of a particular MySQL database.
	private int movieId;
	
	@NotNull
	@Column(name = "title", length=100 , nullable = false)
	private String title;
	
	@Column(name = "description", length=800 , nullable = false)
	private String description;
	
	@NotNull
	@Column(name="language",length = 50 )
	private String language;
		
	
	
	@Column
	private double rating;
	
	@Column
	private double ticketPrice;
	
	@OneToOne //used to map source entity to target entity.
	@JoinColumn(name= "screenId")  //used to specify a column for joining an entity association or element collection.
	//@JsonIgnore
	private Screen screen;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie(int movieId, @NotNull String title, String description, @NotNull String language, double rating,
			double ticketPrice, Screen screen) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.language = language;
		this.rating = rating;
		this.ticketPrice = ticketPrice;
		this.screen = screen;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", description=" + description + ", language="
				+ language + ", rating=" + rating + ", ticketPrice=" + ticketPrice + ", screen=" + screen + "]";
	}

	
	
	
	
	
	

	}