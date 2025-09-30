package banking.bankingSystem.controller;

import banking.bankingSystem.entity.Account;
import banking.bankingSystem.entity.TransactionLog;
import banking.bankingSystem.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Account createAccount(@RequestParam String accountHolder, @RequestParam double balance){
        return accountService.createAccount(accountHolder,balance);
    }

    @PostMapping("/{id}/deposite")
    public Account deposite(@PathVariable Long id, @RequestParam double balance){
        return accountService.deposit(id, balance);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam double balance){
        return accountService.Withdraw(id, balance);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }

    @GetMapping("/all")
    public List<Account> accountList(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/logs")
    public List<TransactionLog> transactionLogs(@PathVariable Long id){
        return accountService.getTransactions(id);
    }
}
