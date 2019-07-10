package com.main.java.component;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TransactionSchedulerTest {

	@Mock
	TransactionScheduler transactionScheduler;

	@Test
	public void testForScheduler() throws JSONException {
		transactionScheduler.getStatistics();
	}
}