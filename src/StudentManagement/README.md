# Student Management System (Java + MySQL)

A console-based Java application to manage student data using CRUD operations connected to a MySQL database.

## 📁 Location

This project is located inside the `StudentManagementSystem/` folder of this repository.

---

## 📌 Features

- ✅ Add a new student (with validation)
- ❌ Remove a student
- 🔁 Update student details
- 👁️ Display student information

---

## 💻 Technologies Used

- Java (JDK 8+)
- MySQL
- JDBC
- MySQL Connector/J

---

## 🗂️ Folder Structure

```
StudentManagementSystem/
├── src/
│   └── Student.java              # Main Java source file
├── db/
│   └── schema.sql                # SQL script to set up the database and table
├── lib/
│   └── mysql-connector-java-8.x.x.jar  # JDBC driver
├── README.md
└── .gitignore
```

---

## 🧪 Database Setup

1. **Run the SQL schema:**

Open MySQL terminal or GUI (like MySQL Workbench) and run:

```sql
SOURCE db/schema.sql;
```

This will:
- Create a database `StudentSystem`
- Create a table `STUDENTS` with fields: `roll_no`, `name`, `email`, `grade`

---

## ⚙️ Configuration

Edit the following line in your Java code if needed:

```java
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSystem", "root", "your_password");
```

Make sure:
- MySQL server is running locally
- The database credentials are correct
- The `mysql-connector-java` `.jar` is in the `lib/` folder

---

## ▶️ How to Compile and Run

From inside the `StudentManagementSystem/` folder:

### 1. Compile:

```bash
javac -cp "lib/mysql-connector-java-8.x.x.jar" src/Student.java
```

### 2. Run:

```bash
java -cp ".:lib/mysql-connector-java-8.x.x.jar:src" Student
```

(Use `;` instead of `:` on Windows)

---

## 🛑 Notes

- **Do not commit actual database credentials** if you later make your connection dynamic.
- Email validation uses a simple regex, and `"null"` (case-insensitive) can be passed to skip it.
- This app assumes the table is already created. Run `schema.sql` before executing the app.

---

## 📄 License

This project is free to use for educational and personal learning purposes.
