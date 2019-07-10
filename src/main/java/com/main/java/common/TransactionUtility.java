package com.main.java.common;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.main.java.domain.Transaction;

/**
 * This is a utility class with methods required for transaction processing.
 */

public class TransactionUtility {

	private static Logger LOG = LoggerFactory.getLogger(TransactionUtility.class);

	private static Date validationTime = new Date(System.currentTimeMillis() - 60000);

	/**
	 * This method checks whether the given transaction is older than 60 secs.
	 * 
	 * @param transactionTimestamp
	 * @return Boolean
	 */
	public Boolean isOlderThanSixtySecs(Long transactionTimestamp) {

		LOG.info("Validating the timestamp of the transaction...");

		Date transactionTime = new Date(Long.parseLong(transactionTimestamp.toString()));
		return transactionTime.before(validationTime);
	}

	/**
	 * This method returns the sum of all the transactions in last 60 secs.
	 * 
	 * @param transactionsList
	 * @return Double
	 */
	public Double calculateSum(List<Transaction> transactionsList) {

		LOG.info("Calculating the sum of all the transactions in last 60 secs...");

		Double sumOfTransactions = 0.0;
		for (Transaction transaction : transactionsList) {
			Date transactionTime = new Date(Long.parseLong(transaction.getTranTimestamp().toString()));
			if (transactionTime.after(validationTime)) {
				sumOfTransactions = sumOfTransactions + transaction.getAmount();
			}

		}
		return sumOfTransactions;
	}

	/**
	 * This method returns the average of all the transactions in last 60 secs.
	 * 
	 * @param transactionsList
	 * @return Double
	 */
	public Double calculateAverage(List<Transaction> transactionsList) {

		LOG.info("Calculating the average of all the transactions in last 60 secs...");

		Double sumOfTransactions = 0.0;
		int count = 0;
		for (Transaction transaction : transactionsList) {
			Date transactionTime = new Date(Long.parseLong(transaction.getTranTimestamp().toString()));
			if (transactionTime.after(validationTime)) {
				sumOfTransactions = sumOfTransactions + transaction.getAmount();
				count++;
			}

		}
		return (sumOfTransactions / count);
	}

	/**
	 * This method returns the maximum of all the transactions in last 60 secs.
	 * 
	 * @param transactionsList
	 * @return Double
	 */
	public Double getMaxTranValue(List<Transaction> transactionsList) {

		LOG.info("Calculating the max of all the transactions in last 60 secs...");

		Double maxTranValue = 0.0;
		for (Transaction transaction : transactionsList) {
			Date transactionTime = new Date(Long.parseLong(transaction.getTranTimestamp().toString()));
			if ((transaction.getAmount() > maxTranValue) && (transactionTime.after(validationTime))) {
				maxTranValue = transaction.getAmount();
			}
		}
		return maxTranValue;
	}

	/**
	 * This method returns the minimum of all the transactions in last 60 secs.
	 * 
	 * @param transactionsList
	 * @return Double
	 */
	public Double getMinTranValue(List<Transaction> transactionsList) {

		LOG.info("Calculating the min of all the transactions in last 60 secs...");

		Double minTranValue = 0.0;
		int indx;
		for (indx = 0; indx < transactionsList.size(); indx++) {
			Transaction transaction = transactionsList.get(indx);
			Date transactionTime = new Date(Long.parseLong(transaction.getTranTimestamp().toString()));
			if (indx == 0) {
				minTranValue = transaction.getAmount();
			}
			if ((transaction.getAmount() < minTranValue) && (transactionTime.after(validationTime))) {
				minTranValue = transaction.getAmount();
			}
		}
		return minTranValue;
	}

	/**
	 * This method returns the count of all the transactions in last 60 secs.
	 * 
	 * @param transactionsList
	 * @return Double
	 */
	public Long getCountOfTransactions(List<Transaction> transactionsList) {

		LOG.info("Calculating the count of all the transactions in last 60 secs...");

		Double countOfTrans = 0.0;
		for (Transaction transaction : transactionsList) {
			Date transactionTime = new Date(Long.parseLong(transaction.getTranTimestamp().toString()));
			if (transactionTime.after(validationTime)) {
				countOfTrans++;
			}
		}
		return countOfTrans.longValue();
	}
}