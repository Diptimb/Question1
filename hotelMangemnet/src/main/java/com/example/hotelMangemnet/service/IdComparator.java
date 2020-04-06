package com.example.hotelMangemnet.service;

import java.util.Comparator;

import com.example.hotelMangemnet.entity.Hotel;

public class IdComparator implements Comparator<Hotel> {

	@Override
	public int compare(Hotel arg0, Hotel arg1) {
		 return arg0.getId()-arg1.getId();
				 
	}
	

}
