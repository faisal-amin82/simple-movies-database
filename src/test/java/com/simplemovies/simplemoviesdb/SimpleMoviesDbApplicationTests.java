package com.simplemovies.simplemoviesdb;

import com.json.parser.JsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SimpleMoviesDbApplicationTests {

	JsonParser jsonParser = new JsonParser();

	@Test
	void testStringIsAValidJson() {

		assertTrue(JsonParser.validateJsonObject("{ name : someName}"));
		assertFalse(JsonParser.validateJsonObject("{ name : someName,,}"));
		assertFalse(JsonParser.validateJsonObject("{ name : someName, name: anotherName"));
		assertFalse(JsonParser.validateJsonObject("{ name : { someName}"));
	}

	@Test
	void testMethodReturnsValidJson() {

		assertThrows(IllegalArgumentException.class, () -> JsonParser.getNextObject("{name : {").size());

		assertEquals(0, JsonParser.getNextObject("{ name : someName,,}").size());

		assertEquals(1, JsonParser.getNextObject("{ name : someName},,}").size());

		assertEquals(2, JsonParser.getNextObject("{ name : someName},,{ name : someName}}").size());


	}

}
