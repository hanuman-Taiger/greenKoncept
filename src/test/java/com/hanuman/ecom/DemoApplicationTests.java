package com.hanuman.ecom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


class DemoApplicationTests {

	@Test
	void contextLoads() {

		String text = "This is India is is ";
		String[] words = text.split(" ");
		Map<String, Integer> wordsCount = new HashMap<>();
		for (String word : words) {
			if(wordsCount.containsKey(word)) {
				wordsCount.computeIfPresent(word, (k,v) -> v + 1);
			} else {
				wordsCount.put(word, 1);
			}

		}
		System.out.println(wordsCount);
	}

}
