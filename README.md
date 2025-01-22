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
│   │   │           ├── model
│   │   │           │   ├── Beneficiary.java
│   │   │           │   ├── Donor.java
│   │   │           │   ├── Donation.java
│   │   │           │   └── User.java
│   │   │           ├── dao
│   │   │           │   ├── BeneficiaryDAO.java
│   │   │           │   ├── DonorDAO.java
│   │   │           │   ├── DonationDAO.java
│   │   │           │   └── UserDAO.java
│   │   │           ├── util
│   │   │           │   └── DatabaseConnection.java
│   │   │           └── Main.java
│   │   └── resources
│   │       └── database.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── charity
│       │           └── test
│       │               ├── BeneficiaryDAOTest.java
│       │               ├── DonorDAOTest.java
│       │               └── DonationDAOTest.java
│       └── resources
│           └── test-connection.properties
├── pom.xml
└── README.md
```

### Explanation of the Project Structure:
1. src/main/java/com/charity/model: Contains Java classes that map to the database tables (e.g., Beneficiary,        Donor, Donation, User).
2. src/main/java/com/charity/dao: Contains classes responsible for interacting with the database (e.g.,
   BeneficiaryDAO, DonorDAO).
3. src/main/java/com/charity/util: Contains utility classes like DatabaseConnection.java for database connections.
4. src/test/java/com/charity/test: Contains unit tests for the DAO classes.
5. src/main/resources/database.properties: Configuration file for database connection properties.
6. pom.xml: Maven build file that manages dependencies and build configurations.

## 📌 Conclusion
This database is structured to efficiently manage charity operations, ensuring seamless tracking of beneficiaries, donors, and donations. Future expansions can include additional modules like reports and notifications.

## Notes:
1. pom.xml: In the pom.xml file, you will define dependencies such as JDBC and MySQL, along with build               configurations for your Maven project.
2. Project Structure: The project is organized using the standard Maven project structure, which facilitates         dependency management and testing.

## If you need additional details about pom.xml or how to set up the dependencies, feel free to ask!
