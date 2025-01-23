# Charity Association Database Design

## 📌 Introduction
This database is designed for a charity association to manage beneficiaries, donors, and donations efficiently. It utilizes *MySQL* as the database management system and *JDBC* for database interaction in a Java desktop application.

## 📋 Database Tables

### 🏠 Beneficiaries Table (beneficiaries)
Stores information about individuals receiving assistance.

| Column         | Type         | Constraints                     | Description |
|----------------|--------------|---------------------------------|-------------|
| id           | INT          | PRIMARY KEY, AUTO_INCREMENT     | Beneficiary ID |
| name         | VARCHAR(100) | NOT NULL                        | Full name |
| age          | INT          | NULL                            | Age |
| needs        | TEXT         | NULL                            | Needs description |
| social_status| VARCHAR(50)  | NULL                            | Social status |
| phone        | VARCHAR(20)  | NULL                            | Contact number |
| address      | TEXT         | NULL                            | Address |
| registration_date | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP    | Date registered |

---

### 🤝 Donors Table (donors)
Stores information about individuals or organizations making donations.

| Column         | Type         | Constraints                     | Description |
|----------------|--------------|---------------------------------|-------------|
| id           | INT          | PRIMARY KEY, AUTO_INCREMENT     | Donor ID |
| name         | VARCHAR(100) | NOT NULL                        | Donor name |
| phone        | VARCHAR(20)  | NULL                            | Contact number |
| email        | VARCHAR(100) | NULL                            | Email address |
| donation_type| VARCHAR(50)  | NULL                            | Type of donation (money, food, clothes, etc.) |
| address      | TEXT         | NULL                            | Address |
| registration_date | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP    | Date registered |

---

### 💰 Donations Table (donations)
Tracks donations and links donors to beneficiaries.

| Column         | Type         | Constraints                     | Description |
|----------------|--------------|---------------------------------|-------------|
| id           | INT          | PRIMARY KEY, AUTO_INCREMENT     | Donation ID |
| donor_id     | INT          | FOREIGN KEY REFERENCES donors(id) ON DELETE CASCADE | Donor reference |
| beneficiary_id | INT        | FOREIGN KEY REFERENCES beneficiaries(id) ON DELETE SET NULL | Beneficiary reference |
| amount       | DECIMAL(10,2)| NULL                            | Donation amount (if monetary) |
| donation_type| VARCHAR(50)  | NULL                            | Type of donation |
| description  | TEXT         | NULL                            | Additional notes |
| donation_date| TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP      | Date of donation |

---

### 🔐 Users Table (users)
Stores system users (staff and admins) for authentication and authorization.

| Column         | Type         | Constraints                     | Description |
|----------------|--------------|---------------------------------|-------------|
| id           | INT          | PRIMARY KEY, AUTO_INCREMENT     | User ID |
| username     | VARCHAR(50)  | UNIQUE, NOT NULL                | Login username |
| password     | VARCHAR(255) | NOT NULL                        | Encrypted password |
| role         | ENUM('admin', 'staff') | NOT NULL              | User role (admin/staff) |
| created_at   | TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP       | Account creation date |

---

## 🔗 Table Relationships
- **donations** table links **donors** and **beneficiaries**.
- **users** table is independent for managing authentication.

## ⚙ Setting Up the Database
1. Create the database:
   ```sql
   CREATE DATABASE kherko;
   ```
2. Select the database:
   ```sql
   USE kherko;
   ```
3. Define tables based on the schema above.

## 🛠 Hibernate Integration with MySQL
- Configure *Hibernate ORM* to map Java entities to database tables.
- Use hibernate.cfg.xml for database connection setup in the Java project.

## 🎨 Graphical User Interface (GUI)
To enhance usability, the project includes a graphical user interface (GUI) using **JavaFX** or **Swing**. The GUI will include:
- **Main Dashboard:** Overview of donations, beneficiaries, and donors.
- **Donor Management:** Add, update, and remove donors.
- **Beneficiary Management:** Manage beneficiaries and their details.
- **Donation Tracking:** Log donations and link them to donors and beneficiaries.
- **User Authentication:** Secure login system for staff and admins.

## 🗂 Project Structure (Maven)
Below is the structure of the project when using Maven for dependency management and building the project.

```
charity-association
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── charity
│   │   │           ├── model  # Contains entity classes representing database tables
│   │   │           │   ├── Beneficiary.java
│   │   │           │   ├── Donor.java
│   │   │           │   ├── Donation.java
│   │   │           │   └── User.java
│   │   │           ├── dao  # Data Access Object (DAO) layer for database interaction
│   │   │           │   ├── BeneficiaryDAO.java
│   │   │           │   ├── DonorDAO.java
│   │   │           │   ├── DonationDAO.java
│   │   │           │   └── UserDAO.java
│   │   │           ├── gui  # Graphical User Interface components
│   │   │           │   ├── MainDashboard.java
│   │   │           │   ├── DonorForm.java
│   │   │           │   ├── BeneficiaryForm.java
│   │   │           │   ├── DonationForm.java
│   │   │           │   ├── LoginForm.java
│   │   │           │   └── AdminPanel.java
│   │   │           ├── util  # Utility classes such as database connection handlers
│   │   │           │   └── DatabaseConnection.java
│   │   │           └── Main.java  # Entry point of the application
│   │   └── resources
│   └── test
│       └── java
├── pom.xml  # Maven build file containing dependencies
└── README.md
```

## 📌 Conclusion
This database is structured to efficiently manage charity operations, ensuring seamless tracking of beneficiaries, donors, and donations. The inclusion of a GUI makes the system more user-friendly and accessible for staff and administrators.

## Notes:
1. **pom.xml:** Defines dependencies such as JDBC, MySQL, Hibernate, and JavaFX/Swing.
2. **Project Structure:** Organized using the standard Maven structure for easy dependency management and testing.

## If you need additional details about GUI implementation or specific functionalities, feel free to ask!

