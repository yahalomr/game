package com.flolive;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flolive.controllers.GameController;

@SpringBootTest
class GameApplicationTests {

	@Autowired
	GameController gameController;
	
	@Test
	void contextLoads() {
		assertNotNull(gameController);
	}

}
