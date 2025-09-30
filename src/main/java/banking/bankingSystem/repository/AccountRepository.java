package banking.bankingSystem.repository;

import banking.bankingSystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
