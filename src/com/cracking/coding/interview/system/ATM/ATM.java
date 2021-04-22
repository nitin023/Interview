package com.cracking.coding.interview.system.ATM;

import com.cracking.coding.interview.system.bookMyShow.Address;

public class ATM {
    int atmId;
    Address location;
    CashDispenser cashDispenser;
    CardReader cardReader;
    Screen screen;
    ChequeDeposit chequeDeposit;
    CashDeposit cashDeposit;
    Keypad keypad;
    BankService bankService;
}
