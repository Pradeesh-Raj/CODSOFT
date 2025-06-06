# ATM Interface

This is a Java-based console application that simulates basic ATM operations using a MySQL database for persistent storage. The application allows users to log in using their account number and perform transactions such as deposits, withdrawals, and balance checks.

## 📁 Project Structure

```
ATM_Interface/
├── ATM_Back.java
├── README.md
└── schema.sql
```

## 💻 Technologies Used

- **Java**
- **MySQL**
- **JDBC** (Java Database Connectivity)

## 🔑 Features

- User authentication via account number
- Withdraw money (with balance check)
- Deposit money (prevents zero/negative values)
- Check current balance
- Secure database operations using Prepared Statements

## 🗄️ Database Configuration

Make sure you have MySQL installed and running. The connection string used:
```
jdbc:mysql://localhost:3306/ATM
username: root
password: pradeesh
```

### 📌 Update `ATM_Back.java` if your database credentials differ.

## 🧪 Setup Instructions

1. **Create Database & Table**  
   Use the [`schema.sql`](schema.sql) script provided to create the required database and table.

   ```bash
   mysql -u root -p < schema.sql
   ```

2. **Add sample user**
   You can manually insert users into the database to test functionality.

3. **Run the Application**  
   Use your preferred Java IDE or command-line tools to compile and run the program.

## 📝 Example Usage

```java
ATM_Back atm = new ATM_Back();
System.out.println(atm.validateUser(12345678)); // Authenticate
System.out.println(atm.deposit(500));           // Deposit
System.out.println(atm.withdraw(200));          // Withdraw
System.out.println(atm.checkBalance());         // Check Balance
```

## 🙏 Credits

This project was developed as part of a learning internship at **CodSoft**.
