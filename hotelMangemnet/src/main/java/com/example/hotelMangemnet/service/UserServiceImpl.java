package com.example.hotelMangemnet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelMangemnet.entity.Hotel;
import com.example.hotelMangemnet.entity.Room;
import com.example.hotelMangemnet.entity.User;
import com.example.hotelMangemnet.repository.HotelRepository;
import com.example.hotelMangemnet.repository.RoomRepository;
import com.example.hotelMangemnet.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
@Autowired
private UserRepository userRepo;
@Autowired
private RoomRepository roomRpo;
@Autowired
private HotelRepository hotelRepo;
@Override
public User insertUser(User user) {
	System.out.println(user.getRooms().toString());
	Set<Room> rooms=user.getRooms();
System.out.println(rooms.toString());
for(Room r:rooms) {
Room room=roomRpo.findById(r.getId()).get();

User use=new User(user.getId(),user.getName());
System.out.println(use.getName());
	room.setUser(use);
	System.out.println(room.toString());
	user.setRooms(room);
	roomRpo.save(room);
	user.setId(room.getUser().getId());
//		System.out.println(user.toString());

		return user;}
		
	return null;
}


public Map<Integer,User> getAllUers(int hotelId){
	//Hotel h=hotelRepo.findById(hotelId).get();
	Map<Integer,User> map=new HashMap<Integer, User>();
	List<Room> rooms=roomRpo.findAll();
	List<User> users=new ArrayList<User>();
	for(Room room:rooms) {
		if(room.getHotel().getId()==hotelId) {
			User use=room.getUser();
			//users.add(use);
			map.put(use.getId(), use);
		}
		
	}
	
	return map;
}

public Map<Integer,Hotel> getAllHotels(double booking){
	List<Hotel> hotel=hotelRepo.findAll();
	Map<Integer,Hotel> map=new TreeMap<Integer, Hotel>();
	List<Room> rooms=roomRpo.findAll();
	for(Hotel h:hotel) {
		int sum=0;
		for(Room r:rooms) {
			if(r.getHotel().getId()==h.getId())
				sum+=r.getCost();
		}
		if(sum>booking) {
			map.put(h.getId(), h);
		}
	}
	return map;
}
}
