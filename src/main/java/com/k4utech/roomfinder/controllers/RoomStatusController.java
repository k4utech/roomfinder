package com.k4utech.roomfinder.controllers;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.k4utech.roomfinder.cache.RoomStatusCache;
import com.k4utech.roomfinder.models.RoomStatus;

@RestController
@RequestMapping("/api/v1/roomstatus")
public class RoomStatusController {
	
	@GetMapping
	public Collection<RoomStatus> list() {
		return RoomStatusCache.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody RoomStatus status) {
		RoomStatusCache.save(status);
	}
	
	@GetMapping("/{id}")
	public RoomStatus get(@PathParam("id") int id) {
		return RoomStatusCache.getOne(id);
	}
	
	
}
