package com.rak.scheduler.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
class AvailableSlotServiceTest {

	@Autowired
	private AvailableSlotService availableSlotService;
	
	@Autowired
	private UserService userService; // TODO figure out user creation for test - data.sql or something else
	
	@Test
	void testSaveOrUpdates() {
		
//		User user = new User();
//		userService.saveOrUpdates(user);
//		AvailableSlot availableSlot = new AvailableSlot();
//		this.availableSlotService.saveOrUpdates(availableSlot);
		//fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetAvailableSlots() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetAvailableSlotById() {
		//fail("Not yet implemented");
	}

}
