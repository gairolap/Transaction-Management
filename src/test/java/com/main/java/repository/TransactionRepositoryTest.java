/**
 * 
 */
package com.main.java.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import com.main.java.domain.Transaction;

/**
 * This is a test class for transaction repository. 
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

	private Transaction transaction = new Transaction();

	@Before
	public void setUp() {
		Double amount = 100.5;
		long tranTimestamp = 1503100800;
		transaction.setAmount(amount);
		transaction.setTranTimestamp(tranTimestamp);
	}

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	public void testToFindAll() {

		List<Transaction> listOfTransactions = transactionRepository.findAll();
		assertTrue(listOfTransactions.size() > 0);
	}

	@Test
	public void testForResponseOfFindAll() {

		List<Transaction> listOfTransactions = transactionRepository.findAll();
		assertFalse(ObjectUtils.isEmpty(listOfTransactions.get(0).getAmount()));
		assertFalse(ObjectUtils.isEmpty(listOfTransactions.get(0).getTranTimestamp()));
	}
}