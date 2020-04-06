package com.example.hotelMangemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelMangemnet.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
