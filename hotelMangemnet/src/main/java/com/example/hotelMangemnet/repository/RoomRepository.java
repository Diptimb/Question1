package com.example.hotelMangemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelMangemnet.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
