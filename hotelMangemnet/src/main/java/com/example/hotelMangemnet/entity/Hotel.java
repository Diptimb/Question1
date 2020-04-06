package com.example.hotelMangemnet.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="hotel", uniqueConstraints={@UniqueConstraint(columnNames={"hotel_id"})})
public class Hotel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "hotel_id")
	private int hotel_id;
@Column(name = "hotelName")
	private String hotelname;

	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})	
	private Set<Room> rooms=new HashSet<Room>();
	
	public Hotel() {
		super();
	}
	public Hotel(int hotel_id, String hotelname) {
		super();
		this.hotel_id = hotel_id;
		this.hotelname = hotelname;
	}
	public Hotel(int id, String hotelname, Set<Room> rooms) {
		super();
		this.hotel_id = id;
		this.hotelname = hotelname;
		this.rooms = rooms;
	}
	public int getId() {
		return hotel_id;
	}
	public void setId(int id) {
		this.hotel_id = id;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> room) {
		rooms.addAll(room);
	   this.rooms=rooms;
		}
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotelname=" + hotelname + ",rooms="+rooms.toString()+"]";
	}
	
	
	
	}

