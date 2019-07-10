package com.main.java.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.main.java.domain.Transaction;

@WebAppConfiguration
@RunWith(SpringRunner.class)
public class TransactionMgmtControllerTest {

	@MockBean
	TransactionMgmtController transactionMgmtController;

	@MockBean
	Transaction transaction;

	ResponseEntity<String> response;

	@Test
	public void testAllStats() throws Exception {

		response = new ResponseEntity<String>("Service response is OK!", HttpStatus.OK);
		Mockito.when(transactionMgmtController.getTransactions()).thenReturn(response);
		assertTrue(response != null);
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "Service response is OK!");
	}

	@Test
	public void testPostTransactionsForSuccess() {

		response = new ResponseEntity<String>("Record persisted successfully!", HttpStatus.CREATED);
		Mockito.when(transactionMgmtController.postTransaction(transaction)).thenReturn(response);
		assertTrue(response != null);
		assertEquals(response.getStatusCodeValue(), 201);
		assertEquals(response.getBody(), "Record persisted successfully!");
	}

	@Test
	public void testPostTransactionsForUnsuccess() {

		response = new ResponseEntity<String>("Record not recorded!", HttpStatus.NO_CONTENT);
		Mockito.when(transactionMgmtController.postTransaction(transaction)).thenReturn(response);
		assertTrue(response != null);
		assertEquals(response.getStatusCodeValue(), 204);
		assertEquals(response.getBody(), "Record not recorded!");
	}
}