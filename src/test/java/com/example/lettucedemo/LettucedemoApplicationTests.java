package com.example.lettucedemo;

import com.example.lettucedemo.pojo.User;
import com.example.lettucedemo.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LettucedemoApplicationTests {

	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void testString() {
		redisUtils.set("strKey1", "testuser2");
		System.out.println(redisUtils.get("strKey1"));
	}

	@Test
	public void testSerializable() {
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setUID("" + i);
			user.setName("testUser" + i);
			user.setGroupID(i % 10);

			redisUtils.set("usrkey" + i, user);
			System.out.println(redisUtils.get("usrobjkey1"));
		}
	}

}
