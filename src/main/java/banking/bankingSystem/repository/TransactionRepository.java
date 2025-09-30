package banking.bankingSystem.repository;

import banking.bankingSystem.entity.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionLog, Long> {
}
