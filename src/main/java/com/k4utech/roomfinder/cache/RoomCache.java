package com.k4utech.roomfinder.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.k4utech.roomfinder.models.Room;

public class RoomCache {
 
	private static Map<Integer,Room> cacheMap = new ConcurrentHashMap<>();
	
	public static void save(Room room) {
		if(room != null)
			cacheMap.put(room.getId(), room);
	}
	
	public static Room getOne(Integer id) {
			return cacheMap.get(id);
	}
	
	public static Collection<Room> getAll() {
		return cacheMap.values();
}
}
