package banking.bankingSystem.service;

import banking.bankingSystem.entity.Account;
import banking.bankingSystem.entity.TransactionLog;
import banking.bankingSystem.repository.AccountRepository;
import banking.bankingSystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account createAccount(String accountHolder, double balance){

        Account account = new Account();
        account.setAccountHolder(accountHolder);
        account.setBalance(balance);
        return accountRepository.save(account);
    }

    public Account deposit(Long id, double amount){

        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found,"));

        account.setBalance(account.getBalance()+amount);

        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setAccount(account);
        transactionLog.setAmount(amount);
        transactionLog.setTransactionType("Deposite");
        transactionLog.setTime(LocalDateTime.now());

        transactionRepository.save(transactionLog);

        return accountRepository.save(account);
    }

    public Account Withdraw(Long id, double amount){

        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found."));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient Balance.");
        }

        account.setBalance(account.getBalance()-amount);

        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setAccount(account);
        transactionLog.setAmount(amount);
        transactionLog.setTransactionType("Withdraw");
        transactionLog.setTime(LocalDateTime.now());

        transactionRepository.save(transactionLog);
        return accountRepository.save(account);
    }

    public Account getAccount(Long id){

        return accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found."));
    }

    public List<TransactionLog> getTransactions(Long id){

        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found,"));

        return account.getTransactions();
    }

    public List<Account> getAllAccounts(){

        return accountRepository.findAll();
    }

}














