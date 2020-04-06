package com.example.hotelMangemnet.controller;

import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelMangemnet.entity.Hotel;
import com.example.hotelMangemnet.entity.Room;
import com.example.hotelMangemnet.entity.User;
import com.example.hotelMangemnet.service.HotelService;
import com.example.hotelMangemnet.service.RoomService;
import com.example.hotelMangemnet.service.UserService;

@RestController
public class AppController {
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoomService roomService;
	
	
	@RequestMapping(value = "/hotel", method = RequestMethod.POST)
	public Hotel insertIntoHotel(@RequestBody Hotel hotel) {
		// System.out.println(hotel.getRooms().toString());
		return this.hotelService.insertIntoDb(hotel);
	}

	@RequestMapping(value="/add/user", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		//System.out.println(user.get);
		return userService.insertUser(user);
	}
	
	@RequestMapping(value="/add/room/{roomId}/{userId}", method = RequestMethod.PUT)
	public Room assignRoom(@PathVariable int roomId,@PathVariable int userId) {
		return roomService.bookRoom(roomId, userId);
	}
	
	@RequestMapping(value="/get/{hotelId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable int hotelId ){
		Map<Integer,User> map=userService.getAllUers(hotelId);
		 return new ResponseEntity<Map<Integer,User>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/hotels/{price}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable double price ){
		Map<Integer,Hotel> map=userService.getAllHotels(price);
		 return new ResponseEntity<Map<Integer,Hotel>>(map, HttpStatus.OK);
	}
	
}


@RequestMapping(value="/add/room/{roomId}/{userId}", method = RequestMethod.PUT)
	public Room assignRoom(@Valid@PathVariable int roomId,@Valid@PathVariable int userId) {
		return roomService.bookRoom(roomId, userId);
	}
	
	@RequestMapping(value="/get/{hotelId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable int hotelId ){
		Map<Integer,User> map=userService.getAllUers(hotelId);
		 return new ResponseEntity<Map<Integer,User>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/hotels/{price}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable double price ){
		Map<Integer,Hotel> map=userService.getAllHotels(price);
		 return new ResponseEntity<Map<Integer,Hotel>>(map, HttpStatus.OK);
	}
