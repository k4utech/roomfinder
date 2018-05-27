package com.k4utech.roomfinder.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.k4utech.roomfinder.models.RoomStatus;

public class RoomStatusCache {
	private static Map<Integer,RoomStatus> statusMap = new ConcurrentHashMap<>();
	
	public static void save(RoomStatus roomStatus) {
		if(roomStatus != null)
			statusMap.put(roomStatus.getId(), roomStatus);
	}
	
	public static RoomStatus getOne(Integer id) {
		return statusMap.get(id);
	}
	
	public static Collection<RoomStatus> getAll() {
		return statusMap.values();
	}
	
}
