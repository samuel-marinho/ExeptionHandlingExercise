package entities.model;

import entities.model.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double wLimit;

    public Account() {
        super();
    }

    public Account(Integer number, String holder, Double balance, Double wLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.wLimit = wLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getwLimit() {
        return wLimit;
    }

    public void setwLimit(Double wLimit) {
        this.wLimit = wLimit;
    }

    public void deposit (double amount){
        balance += amount;
    }
    public void withdraw (double amount){
        validateWithdraw(amount);
        balance -= amount;
    }
    private void validateWithdraw(double amount){
        if (amount > getwLimit()){
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > getBalance()){
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }

}
