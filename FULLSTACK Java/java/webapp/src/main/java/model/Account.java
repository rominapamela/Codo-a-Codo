/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rpv15
 */
public class Account {
    private int accountnumber;
    private String type;
    private String currency;
    private Double balance;
    private int iduser;

    public Account(int accountnumber, String type, String currency, Double balance, int iduser) {
        this.accountnumber = accountnumber;
        this.type = type;
        this.currency = currency;
        this.balance = balance;
        this.iduser = iduser;
    }

    public int getAccountNumber() {
        return accountnumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountnumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
}