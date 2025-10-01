package banking.bankingSystem.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountHolder;
    private double balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore   // <— do not include logs when serializing Account
    private List<TransactionLog> transactionsLog = new ArrayList<>();

    public Account() {
    }

    public Account(Long id, String accountHolder, double balance, List<TransactionLog> transactionsLog) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionsLog = transactionsLog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<TransactionLog> getTransactions() {
        return transactionsLog;
    }

    public void setTransactions(List<TransactionLog> transactions) {
        this.transactionsLog = transactions;
    }
}
