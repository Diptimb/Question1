package com.example.hotelMangemnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private double cost;
@OneToOne(cascade = CascadeType.PERSIST)
//@JoinTable(name="room_user",joinColumns =@JoinColumn(name="id"),inverseJoinColumns =@JoinColumn(name="user_id") )
@JsonIgnore
private User user;

@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
private Hotel hotel;
public Hotel getHotel() {
	return hotel;
} 
public Room(int id, double cost, User user, Hotel hotel) {
	super();
	this.id = id;
	this.cost = cost;
	this.user = user;
	this.hotel = hotel;
}
public void setHotel(Hotel hotels) {
	
	this.hotel = hotels;
}
public Room() {
	super();
}
@Override
public String toString() {
	return "Room [id=" + id + ", cost=" + cost + " ]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
