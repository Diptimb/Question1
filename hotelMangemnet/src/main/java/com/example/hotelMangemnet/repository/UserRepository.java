package com.example.hotelMangemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelMangemnet.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
