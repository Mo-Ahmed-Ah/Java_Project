# Kherko Database Documentation

## Overview

Kherko is a structured database designed to manage people, their statuses, and various assistance programs. It consists of five interconnected tables: `Status`, `People`, `People_Status`, `Type_of_helping`, and `Assistances`. These tables work together to store and manage information about individuals, their statuses, and the assistance they receive.

## Database Schema

### 1. Table: Status

Stores different status types that can be assigned to individuals.

| Column Name | Data Type   | Constraints                 |
| ----------- | ----------- | --------------------------- |
| id          | INT         | PRIMARY KEY, AUTO_INCREMENT |
| stat_name   | VARCHAR(50) | NOT NULL                    |

**Available Functions:**

- Add a new status: ❌ Finsh without interface
- Delete a status: ❌ Finsh without interface
- Retrieve all status types: ❌ Finsh without interface
- Retrieve status name with id : ❌ Finsh without interface
- Check id is true : ❌ Finsh without interface

### 2. Table: People

Stores details about individuals, including their names, contact information, and other personal details.

| Column Name | Data Type    | Constraints                 |
| ----------- | ------------ | --------------------------- |
| id          | INT          | PRIMARY KEY, AUTO_INCREMENT |
| fname       | VARCHAR(50)  | NOT NULL                    |
| lname       | VARCHAR(50)  | NOT NULL                    |
| nickname    | VARCHAR(50)  | NULL                        |
| city        | VARCHAR(50)  | NULL                        |
| street      | VARCHAR(100) | NULL                        |
| phone       | VARCHAR(15)  | NULL                        |
| gender      | CHAR(1)      | NOT NULL                    |
| gid         | CHAR(14)     | NULL                        |
| notes       | TEXT         | NULL                        |
| joindate    | DATE         | DEFAULT CURRENT_TIMESTAMP   |

**Notes:**

- `gender` values:
  - `F` = Female
  - `M` = Male

**Available Functions:**

- Add a new person: ❌ Not implemented
- Delete a person: ❌ Not implemented
- Search for a person using:
  - id
  - name
  - nickname
  - location
  - phone
  - gid
  - joindate
  - gender

### 3. Table: People_Status

Maintains the relationship between people and their assigned statuses.

| Column Name | Data Type | Constraints           |
| ----------- | --------- | --------------------- |
| people_ID   | INT       | FOREIGN KEY, NOT NULL |
| stat_ID     | INT       | FOREIGN KEY, NOT NULL |

**Relationships:**

- `people_ID` references `id` in the `People` table with `ON DELETE CASCADE` and `ON UPDATE CASCADE`.
- `stat_ID` references `id` in the `Status` table with `ON DELETE CASCADE` and `ON UPDATE CASCADE`.

**Available Functions:**

- Assign a status to a person: ❌ Not implemented
- Delete a status: ❌ Not implemented
- Update a status: ❌ Not implemented
- Search for people by status type: ❌ Not implemented

### 4. Table: Type_of_helping

Defines different types of assistance available for people.

| Column Name  | Data Type | Constraints                 |
| ------------ | --------- | --------------------------- |
| id           | INT       | PRIMARY KEY, AUTO_INCREMENT |
| helping_name | CHAR(250) | NOT NULL                    |

**Available Functions:**

- Add a new type of helping: ❌ Not implemented
- Delete a type of helping: ❌ Not implemented
- Retrieve all types of helping: ❌ Not implemented

### 5. Table: Assistances

Tracks assistance provided to individuals.

| Column Name     | Data Type | Constraints                 |
| --------------- | --------- | --------------------------- |
| id              | INT       | PRIMARY KEY, AUTO_INCREMENT |
| people_ID       | INT       | FOREIGN KEY, NOT NULL       |
| helping_ID      | INT       | FOREIGN KEY, NOT NULL       |
| notes           | TEXT      | NULL                        |
| Assistance_date | DATE      | DEFAULT CURRENT_TIMESTAMP   |
| value           | CHAR(100) | NOT NULL                    |

**Relationships:**

- `people_ID` references `id` in the `People` table with `ON DELETE CASCADE` and `ON UPDATE CASCADE`.
- `helping_ID` references `id` in the `Type_of_helping` table with `ON DELETE CASCADE` and `ON UPDATE CASCADE`.

**Available Functions:**

- Add assistance for a person: ❌ Not implemented
- Delete assistance: ❌ Not implemented
- Retrieve all assistances: ❌ Not implemented

## Additional Features

### Get Last ID Function

A function must be implemented to retrieve the last inserted `id` from the `People` table. This function is essential when adding new records to maintain consistency across related tables.

## Future Enhancements

- Implement CRUD operations for all tables.
- Develop a user-friendly interface to interact with the database.
- Enhance security measures, including data validation and role-based access control.

## Usage

To use the Kherko database, follow these steps:

1. **Database Setup**: Ensure that the database is set up with the appropriate tables and relationships as described in the schema.
2. **Data Entry**: Use the available functions to add, update, or delete records in the tables.
3. **Data Retrieval**: Utilize the search and retrieval functions to access the stored data.

## Contributing

Contributions to the Kherko database project are welcome. Please ensure that any changes or additions adhere to the existing schema and functionality.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact

For any questions or suggestions, please contact the project maintainer at [email@example.com](mailto:email@example.com).

---

This documentation serves as a comprehensive guide to the Kherko database schema and its current functionalities. Further updates and implementations will be added as the project evolves.
