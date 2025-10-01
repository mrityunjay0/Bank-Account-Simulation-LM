# Banking System API

This is a simple **Spring Boot Banking System** project that demonstrates basic account management operations (create account, deposit, withdraw, get account details, transaction logs).

## 🚀 Features
- Create a new account with initial balance
- Deposit money into an account
- Withdraw money from an account (with balance check)
- Fetch account details by ID
- Fetch all accounts
- View transaction logs for an account
- In-memory H2 database support

## 🛠️ Tech Stack
- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## 📂 Project Structure
```
bankingSystem/
 ├── controller/       # REST controllers (AccountController)
 ├── entity/           # JPA entities (Account, TransactionLog)
 ├── service/          # Business logic (AccountService)
 ├── repository/       # Spring Data JPA repositories
 └── BankingSystemApplication.java
```

## 🔧 API Endpoints

### Create Account
`POST /account/create?accountHolder={name}&balance={amount}`

Response:
```json
{ "id": 1, "accountHolder": "Alice", "balance": 500.0 }
```

### Deposit
`POST /account/{id}/deposit?balance={amount}`

Response:
```json
{ "id": 1, "accountHolder": "Alice", "balance": 700.0 }
```

### Withdraw
`POST /account/{id}/withdraw?balance={amount}`

Response:
```json
{ "id": 1, "accountHolder": "Alice", "balance": 600.0 }
```

### Get Account by ID
`GET /account/{id}`

### Get All Accounts
`GET /account/all`

### Get Transaction Logs
`GET /account/{id}/logs`

Response:
```json
[
  { "id": 10, "transactionType": "Deposit", "amount": 200.0, "time": "2025-10-01T05:12:00" }
]
```

## ▶️ Running the Project

1. Clone the repository
2. Build & run with Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Open Postman or curl and hit the endpoints at `http://localhost:8080`

## 🗄️ H2 Database Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:bank`
- User: `sa`
- Password: (leave empty)

---

✅ This project is for learning/demo purposes. In production, you’d want to:
- Use DTOs instead of entities in responses
- Replace `double` with `BigDecimal` for money
- Add global exception handling (`@ControllerAdvice`)
- Implement authentication & authorization