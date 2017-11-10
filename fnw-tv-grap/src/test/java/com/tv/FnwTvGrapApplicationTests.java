package com.tv;

import com.tv.service.GrabHotMatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=FnwTvGrapApplication.class)
public class FnwTvGrapApplicationTests {

	@Autowired
	GrabHotMatch grabHotMatch;

	@Test
	public void contextLoads() {

	}

	@Test
	public void test() {
		grabHotMatch.getData();
	}

}
