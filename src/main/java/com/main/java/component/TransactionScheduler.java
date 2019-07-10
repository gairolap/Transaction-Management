package com.main.java.component;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.main.java.controller.TransactionMgmtController;

/**
 * This is the scheduler class that invokes the get operation at regular intervals.
 */

@Component
public class TransactionScheduler {

	private static Logger LOG = LoggerFactory.getLogger(TransactionScheduler.class);

	@Autowired
	TransactionMgmtController transactionMgmtController;

	@Scheduled(fixedRate = 5000)
	public void getStatistics() throws JSONException {

		LOG.info("Fetching the transactions statistics on an interval of 5 secs...");

		transactionMgmtController.getTransactions();
	}
}