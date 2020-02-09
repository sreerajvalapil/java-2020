package com.java10;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.*;

/**
 *
 */
public class Transactions {

    private Map<String, Integer> transactionIdLimitMap;

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        return new Transactions().findRejectedTransactionsResult(transactions, creditLimit);
    }

    public List<String> findRejectedTransactionsResult(List<String> transactions, int creditLimit) {
        transactionIdLimitMap = new HashMap<>();
        return transactions.stream().map(transaction -> findRejectedTransaction(transaction, creditLimit))
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    public String findRejectedTransaction(String transaction, int creditLimit) {
        String[] userDetails = transaction.split(",");
        if (userDetails.length > 0) {
            String transactionID = userDetails[4];
            String user = userDetails[0] + userDetails[1] + userDetails[2];
            int transactionAmount = getUserTransactionAmount(userDetails[3], transactionID, user);

            if (transactionAmount > creditLimit) {
                Integer prevCreditLimit = transactionIdLimitMap.get(user);
                transactionIdLimitMap.put(user, prevCreditLimit -
                        convertStringToInt(userDetails[3],transactionID));

                return transactionID;
            }
        }
        return null;
    }

    private int getUserTransactionAmount(String transactionAmount, String transactionID, String user) {
        try {
            int transAmount = convertStringToInt(transactionAmount,transactionID);
            Integer prevCreditLimit = transactionIdLimitMap.get(user);
            if (prevCreditLimit != null) {
                transAmount = prevCreditLimit + transAmount;
            }
            transactionIdLimitMap.put(user, transAmount);
            return transAmount;
        } catch (NumberFormatException e) {
            throw new IncorrectTransactionException("Incorrect transaction Amount for " + transactionID, e);
        }

    }

    private int convertStringToInt(String transactionAmount,String transactionID) {
        try {
            return Integer.parseInt(transactionAmount);
        } catch (NumberFormatException e) {
            throw new IncorrectTransactionException("Incorrect transaction Amount for " + transactionID, e);
        }

    }

    public class IncorrectTransactionException extends RuntimeException {
        public IncorrectTransactionException(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }
    }

}