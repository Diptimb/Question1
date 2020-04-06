package com.example.hotelMangemnet.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="user")//, uniqueConstraints={@UniqueConstraint(columnNames={"user_id"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_id;
	private String name;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
	//@JoinTable(name="room_user",joinColumns =@JoinColumn(name="user_id"),inverseJoinColumns =@JoinColumn(name="id") )
	
	private Set<Room> rooms=new HashSet<Room>();
	public int getId() {
		return user_id;
	}
	public User() {
		super();
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Room  room) {
     rooms.add(room);	}
	public User(String name, Set<Room> rooms) {
		super();
		this.name = name;
		this.rooms = rooms;
	}
	public User(int id, String name2) {
		this.name = name2;
		this.user_id=id;// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + "]";
	}
	
}
