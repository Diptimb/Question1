package com.example.hotelMangemnet.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelMangemnet.entity.Hotel;
import com.example.hotelMangemnet.entity.Room;
import com.example.hotelMangemnet.repository.HotelRepository;
import com.example.hotelMangemnet.repository.RoomRepository;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;
	@Autowired
	private RoomRepository roomRepo;
	@Override
public Hotel insertIntoDb(Hotel hotel) {
		
		Hotel hotel2 = new Hotel(hotel.getId(), hotel.getHotelname(),hotel.getRooms());
	//	hotel2.setRooms(hotel.getRooms());
//		System.out.println(hotel.getRooms().toString());
		hotel2 = hotelRepo.save(hotel2);
//		hotel2.setRooms(hotel.getRooms());
//		System.out.println(hotel2.getRooms());
		
		Set<Room> room=hotel.getRooms();
		for(Room r:room) {
			r.setHotel(hotel2);
		}
		
		this.roomRepo.saveAll(room);
	 
		 return hotelRepo.getOne(hotel2.getId());
}
}
