package com.cracking.coding.interview.system.ATM;

public interface BankService {
    public boolean isValidUser(CardInfo cardInfo,String pin);
    public Customer getCustomerDetails(CardInfo cardInfo);
    public Transaction executeTransaction(Transaction transaction);
}
