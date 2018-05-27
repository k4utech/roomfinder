package com.k4utech.roomfinder.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.k4utech.roomfinder.cache.RoomCache;
import com.k4utech.roomfinder.models.Room;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

	@GetMapping
	public Collection<Room> list(){
		return RoomCache.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Room room) {
		RoomCache.save(room);
	}
	
	@GetMapping("/{id}")
	public Room get(@PathParam("id") int id) {
		return RoomCache.getOne(id);
	}
}
