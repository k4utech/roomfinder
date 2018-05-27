package com.k4utech.roomfinder.cache;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.k4utech.roomfinder.models.Room;

public class RoomCacheTest {

	@Test
	public void testSaveMethod() {
		//Initially Mapis empty
		assertThat(RoomCache.getAll().size(), equalTo(0));
		
		Room r1 = new Room();
		r1.setId(0);
		r1.setName("0 th Room");
		RoomCache.save(r1);
		assertThat(RoomCache.getAll().size(), equalTo(1));
		
		//Clear should remove all entry of map
		RoomCache.clear();
		assertThat(RoomCache.getAll().size(), equalTo(0));
		
	}

}
