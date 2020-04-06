package com.example.hotelMangemnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelMangemnet.entity.Room;
import com.example.hotelMangemnet.entity.User;
import com.example.hotelMangemnet.repository.RoomRepository;
import com.example.hotelMangemnet.repository.UserRepository;

@Service
public class RoomserviceImpl implements RoomService {

	
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private UserRepository userRepo;
  
	
	@Override
	public Room bookRoom(int id, int userId) {
		Room r=roomRepo.findById(id).get();
		System.out.println(r.toString());
		User use=userRepo.findById(userId).get();
		r.setUser(use);
		use.setRooms(r);
		roomRepo.save(r);
		//userRepo.save(r);
		return r;
	}
}
