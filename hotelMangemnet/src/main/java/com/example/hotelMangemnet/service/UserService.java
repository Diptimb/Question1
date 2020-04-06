package com.example.hotelMangemnet.service;

import java.util.List;
import java.util.Map;

import com.example.hotelMangemnet.entity.Hotel;
import com.example.hotelMangemnet.entity.User;

public interface UserService {
	public User insertUser(User user);
	public Map<Integer, User> getAllUers(int hotelId);
	public Map<Integer,Hotel> getAllHotels(double booking);
}
