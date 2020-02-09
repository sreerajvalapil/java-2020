package com.java10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class VarKeyWordUsage {
    private Map<String,Integer> transactionIdLimitMap;
    public static void main(String[] args) {
        var a = "";
        var list = Arrays.asList(1,"",45,1.0);
        var p = new ByteArrayOutputStream() ;
        String s = "" ;
        s.isEmpty();

        // but you need to return the correct value in order to pass the challenge
        String name ="";
        StringBuilder result = new StringBuilder("Hello");
        if(name == null || name.isEmpty()) {
            result.append(" there!");
        } else {
            result.append(", ").append(name).append("!");
        }
        result.toString();


    }


    public  List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        transactionIdLimitMap = new HashMap<>();
        return transactions.stream().map(transaction->findRejectedTransaction(transaction,creditLimit))
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    public  String findRejectedTransaction(String transaction,int creditLimit) {
        String[] userDetails = transaction.split(",");
        if(userDetails.length > 0) {
            String transactionID = userDetails[4];
            int transactionAmount = getUserTransactionAmount(userDetails[3],transactionID);

            if(transactionAmount>creditLimit) {
                return transactionID ;
            }
        }
        return null;
    }

    private int getUserTransactionAmount(String transactionAmount,String transactionID ) {
        try {
            int transAmount = Integer.parseInt(transactionAmount);
            Integer prevCreditLimit = transactionIdLimitMap.get(transactionID);
            if(prevCreditLimit!=null) {
                transAmount = prevCreditLimit+transAmount;
            }
            transactionIdLimitMap.put(transactionID,transAmount);
            return transAmount;
        } catch(NumberFormatException e) {
            throw new IncorrectTransactionException("Incorrect transaction Amount for " +transactionID,e);
        }

    }

    public class IncorrectTransactionException extends RuntimeException {
        public IncorrectTransactionException(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }
    }


}
