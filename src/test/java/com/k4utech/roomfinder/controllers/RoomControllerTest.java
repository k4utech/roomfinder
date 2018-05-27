package com.k4utech.roomfinder.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.k4utech.roomfinder.cache.RoomCache;
import com.k4utech.roomfinder.models.Room;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RoomControllerTest {

	@Autowired 
	RoomController roomController;
	
	@Before
	public void preTestCaseSetUp() {
		RoomCache.clear();
	}
	
	@Test
	public void testThatInitialRoomCacheIsEmpty() {
		assertThat(roomController.list().size(), equalTo(0));
	}
	
	@Test
	public void testThatAfterAddingEntryInRoomCacheContainsTheEntry() {
		Room room = new Room();
		room.setId(0);
		room.setName("0 th Room");
		roomController.create(room);
		assertThat(roomController.list().size(), equalTo(1));
	}
	
	@Test
	public void testThatAddingSameRoomMoreThanOnceDoNotIncreaseCount() {
		Room room = new Room();
		room.setId(0);
		room.setName("0 th Room");
		roomController.create(room);
		
		Room room2 = new Room();
		room2.setId(0);
		room2.setName("0 th Room");
		roomController.create(room2);
		assertThat(roomController.list().size(), equalTo(1));
	}
	
	@Test
	public void testThatAddingDistinctRoomIncreaseCount() {
		Room room = new Room();
		room.setId(0);
		room.setName("0 th Room");
		roomController.create(room);
		
		Room room2 = new Room();
		room2.setId(1);
		room2.setName("1 th Room");
		roomController.create(room2);
		assertThat(roomController.list().size(), equalTo(2));
	}
	
	@Test
	public void testThatGetReturnValidRoom() {
		Room room = new Room();
		room.setId(0);
		room.setName("0 th Room");
		roomController.create(room);
		
		Room room2 = new Room();
		room2.setId(1);
		room2.setName("1 th Room");
		roomController.create(room2);
		assertThat(roomController.list().size(), equalTo(2));
		
		Room gotRoom = roomController.get(0);
		assertThat(gotRoom, equalTo(room));
		
		gotRoom = roomController.get(1);
		assertThat(gotRoom, equalTo(room2));
		
		gotRoom = roomController.get(2);
		assertThat(gotRoom, equalTo(null));

	}

}
