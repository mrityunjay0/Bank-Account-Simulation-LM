package banking.bankingSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;
    private double amount;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public TransactionLog() {
    }

    public TransactionLog(long id, String transactionType, double amount, LocalDateTime time, Account account) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.time = time;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
