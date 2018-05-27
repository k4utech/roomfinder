package com.k4utech.roomfinder.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.k4utech.roomfinder.cache.RoomCache;
import com.k4utech.roomfinder.cache.RoomStatusCache;
import com.k4utech.roomfinder.models.Room;
import com.k4utech.roomfinder.models.RoomStatus;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RoomStatusControllerTest {

	@Autowired 
	RoomStatusController roomStatusController;
	
	@Before
	public void preTestCaseSetUp() {
		RoomStatusCache.clear();
	}
	
	@Test
	public void testThatInitialRoomStatusCacheIsEmpty() {
		assertThat(roomStatusController.list().size(), equalTo(0));
	}
	
	@Test
	public void testThatAfterAddingEntryInRoomStatusCacheContainsTheEntry() {
		RoomStatus status = new RoomStatus();
		status.setId(0); status.setBusinessDate(Date.valueOf("2018-01-01"));status.setHours("0000");status.setStatus("Y");
		roomStatusController.create(status);
		assertThat(roomStatusController.list().size(), equalTo(1));
	}
	
	@Test
	public void testThatAddingSameRoomMoreThanOnceDoNotIncreaseCount() {
		RoomStatus status = new RoomStatus();
		status.setId(0); status.setBusinessDate(Date.valueOf("2018-01-01"));status.setHours("0000");status.setStatus("Y");
		roomStatusController.create(status);
		assertThat(roomStatusController.list().size(), equalTo(1));
		
		
		RoomStatus status2 = new RoomStatus();
		status2.setId(0); status2.setBusinessDate(Date.valueOf("2018-01-01"));status2.setHours("0000");status2.setStatus("Y");
		roomStatusController.create(status2);
		assertThat(roomStatusController.list().size(), equalTo(1));
	}
	
	@Test
	public void testThatAddingDistinctRoomIncreaseCount() {
		RoomStatus status = new RoomStatus();
		status.setId(0); status.setBusinessDate(Date.valueOf("2018-01-01"));status.setHours("0000");status.setStatus("Y");
		roomStatusController.create(status);
		assertThat(roomStatusController.list().size(), equalTo(1));
		
		
		RoomStatus status2 = new RoomStatus();
		status2.setId(1); status2.setBusinessDate(Date.valueOf("2018-01-01"));status2.setHours("0000");status2.setStatus("Y");
		roomStatusController.create(status2);
		assertThat(roomStatusController.list().size(), equalTo(2));
	}
	
	@Test
	public void testThatGetReturnValidRoom() {
		RoomStatus status = new RoomStatus();
		status.setId(0); status.setBusinessDate(Date.valueOf("2018-01-01"));status.setHours("0000");status.setStatus("Y");
		roomStatusController.create(status);
		assertThat(roomStatusController.list().size(), equalTo(1));
		
		
		RoomStatus status2 = new RoomStatus();
		status2.setId(1); status2.setBusinessDate(Date.valueOf("2018-01-01"));status2.setHours("0000");status2.setStatus("Y");
		roomStatusController.create(status2);
		assertThat(roomStatusController.list().size(), equalTo(2));
		
		RoomStatus gotstatus = roomStatusController.get(0);
		assertThat(gotstatus , equalTo(status));
		
		gotstatus = roomStatusController.get(1);
		assertThat(gotstatus , equalTo(status2));
	}

}
