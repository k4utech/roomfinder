package com.k4utech.roomfinder.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.k4utech.roomfinder.models.RoomStatus;

@RestController
@RequestMapping("/api/v1/roomstatus")
public class RoomStatusController {
	
	@GetMapping
	public List<RoomStatus> list() {
		return new ArrayList<>();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody RoomStatus status) {
		
	}
	
	
	
	
}
