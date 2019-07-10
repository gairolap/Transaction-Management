package com.main.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.java.common.TransactionUtility;
import com.main.java.domain.Transaction;
import com.main.java.repository.TransactionRepository;

/**
 * This is the REST controller class.
 */

@RestController
@EnableAutoConfiguration
public class TransactionMgmtController {

	private static Logger LOG = LoggerFactory.getLogger(TransactionMgmtController.class);

	TransactionUtility transactionUtility = new TransactionUtility();

	@Autowired
	TransactionRepository transactionRepo;

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public ResponseEntity<String> getTransactions() throws JSONException {

		JSONObject responseJson = new JSONObject();
		List<Transaction> transactionsList = transactionRepo.findAll();
		responseJson.put("Sum", transactionUtility.calculateSum(transactionsList));
		responseJson.put("Avg", transactionUtility.calculateAverage(transactionsList));
		responseJson.put("Max", transactionUtility.getMaxTranValue(transactionsList));
		responseJson.put("Min", transactionUtility.getMinTranValue(transactionsList));
		responseJson.put("Count", transactionUtility.getCountOfTransactions(transactionsList));

		LOG.info("Listing transactions categories...: {}", responseJson.toString());

		return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	public ResponseEntity<String> postTransaction(@RequestBody @Valid Transaction transaction) {

		if (transactionUtility.isOlderThanSixtySecs(transaction.getTranTimestamp())) {

			LOG.info("Transaction will not be recorded as transaction timestamp older than a minute!");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT.name(), HttpStatus.NO_CONTENT);
		} else {
			transactionRepo.save(transaction);

			LOG.info("Transaction persisted successfully!");
			return new ResponseEntity<String>(HttpStatus.CREATED.name(), HttpStatus.CREATED);
		}
	}
}
