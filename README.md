# <span style="color:#F39C12;">Kherko Database Documentation</span>

## 1. Table: <span style="color:#3498DB;">`people`</span>

This table stores the basic information of individuals.

### Columns:
| Column Name    | Data Type      | Constraints                        |
|----------------|----------------|------------------------------------|
| <span style="color:#F39C12;">**id**</span>      | <span style="color:#9B59B6;">int</span>           | <span style="color:#1ABC9C;">PRIMARY KEY, AUTO_INCREMENT</span>        |
| <span style="color:#F39C12;">**name**</span>    | <span style="color:#9B59B6;">VARCHAR(50)</span>   | <span style="color:#1ABC9C;">NOT NULL</span>                            |
| <span style="color:#F39C12;">**nickname**</span>| <span style="color:#9B59B6;">VARCHAR(30)</span>   | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**birthdate**</span>| <span style="color:#9B59B6;">DATE</span>         | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**location**</span>| <span style="color:#9B59B6;">VARCHAR(100)</span>  | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**phone**</span>   | <span style="color:#9B59B6;">VARCHAR(15)</span>   | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**gender**</span>  | <span style="color:#9B59B6;">CHAR(1)</span>       | <span style="color:#1ABC9C;">NOT NULL</span>                            |
| <span style="color:#F39C12;">**gid**</span>     | <span style="color:#9B59B6;">CHAR(14)</span>      | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**notes**</span>   | <span style="color:#9B59B6;">TEXT</span>          | <span style="color:#95A5A6;">NULL</span>                                |
| <span style="color:#F39C12;">**joindate**</span>| <span style="color:#9B59B6;">DATE</span>          | <span style="color:#95A5A6;">NULL</span>                                |

### Notes:
- <span style="color:#E74C3C;">**gender**</span>: `F` = Female, `M` = Male
- <span style="color:#E74C3C;">**gid**</span>: Represents the national ID or government identifier of the person.

### Available Functions:
- <span style="color:#2ECC71;">**Add a new person**</span>: ✅ Implemented
- <span style="color:#2ECC71;">**Delete a person**</span>: ✅ Implemented
- <span style="color:#F39C12;">**Search for a person using**</span>:
  - <span style="color:#3498DB;">`id`</span>: ✅ Get one
  - <span style="color:#3498DB;">`name`</span>: ✅ Get all with same name
  - <span style="color:#3498DB;">`nickname`</span>: ✅ Get all with same nickname
  - <span style="color:#3498DB;">`location`</span>: ✅ Get all with same location
  - <span style="color:#3498DB;">`phone`</span>: ✅ Get one
  - <span style="color:#3498DB;">`gid`</span>: ✅ Get one
  - <span style="color:#3498DB;">`joindate`</span>: ✅ Get all joined at the same time
  - <span style="color:#3498DB;">`gender`</span>: ✅ Get all with the same gender

---

## 2. Table: <span style="color:#3498DB;">`family_numbers`</span>

This table keeps track of family members for each individual.

### Columns:
| Column Name  | Data Type      | Constraints                     |
|--------------|----------------|---------------------------------|
| <span style="color:#F39C12;">**people_id**</span>| <span style="color:#9B59B6;">int</span>        | <span style="color:#1ABC9C;">FOREIGN KEY, NOT NULL</span>           |
| <span style="color:#F39C12;">**male**</span>     | <span style="color:#9B59B6;">int</span>        | <span style="color:#95A5A6;">NULL</span>                            |
| <span style="color:#F39C12;">**female**</span>   | <span style="color:#9B59B6;">int</span>        | <span style="color:#95A5A6;">NULL</span>                            |

### Relationships:
- `people_id` is linked to the `id` column in the `people` table with <span style="color:#E74C3C;">`ON DELETE CASCADE`</span> and <span style="color:#E74C3C;">`ON UPDATE CASCADE`</span>.

### Available Functions: ❌ Not Implemented
- Add male and female count
- Update male count
- Update female count
- Delete male count
- Delete female count
- Retrieve male count
- Retrieve female count
- Retrieve both male and female count

---

## 3. Table: <span style="color:#3498DB;">`types_status`</span>

This table defines different status types.

### Columns:
| Column Name  | Data Type      | Constraints                      |
|--------------|----------------|----------------------------------|
| <span style="color:#F39C12;">**id**</span>       | <span style="color:#9B59B6;">int</span>         | <span style="color:#1ABC9C;">PRIMARY KEY, AUTO_INCREMENT</span>      |
| <span style="color:#F39C12;">**statustitle**</span> | <span style="color:#9B59B6;">VARCHAR(30)</span> | <span style="color:#1ABC9C;">NOT NULL</span>                         |

### Available Functions: ❌ Not Implemented
- Add a new status type
- Delete a status type
- Retrieve all status types

---

## 4. Table: <span style="color:#3498DB;">`statue`</span>

This table associates people with status types.

### Columns:
| Column Name    | Data Type      | Constraints                     |
|----------------|----------------|---------------------------------|
| <span style="color:#F39C12;">**id**</span>         | <span style="color:#9B59B6;">int</span>         | <span style="color:#1ABC9C;">PRIMARY KEY, AUTO_INCREMENT</span>      |
| <span style="color:#F39C12;">**typestatus_id**</span>| <span style="color:#9B59B6;">int</span>         | <span style="color:#1ABC9C;">FOREIGN KEY, NOT NULL</span>            |
| <span style="color:#F39C12;">**people_id**</span>  | <span style="color:#9B59B6;">int</span>         | <span style="color:#1ABC9C;">FOREIGN KEY, NOT NULL</span>            |

### Relationships:
- `typestatus_id` is linked to the `id` column in the `types_status` table with <span style="color:#E74C3C;">`ON DELETE CASCADE`</span> and <span style="color:#E74C3C;">`ON UPDATE CASCADE`</span>.
- `people_id` is linked to the `id` column in the `people` table with <span style="color:#E74C3C;">`ON DELETE CASCADE`</span> and <span style="color:#E74C3C;">`ON UPDATE CASCADE`</span>.

### Available Functions: ❌ Not Implemented
- Assign a status to a person
- Delete a status
- Update a status
- Search for people by status type

---

## Additional Notes:
- **You must create the `get last id` function** because it is crucial for generating a new person's ID.
- **Table `family_numbers`**:
  - It is recommended to add a primary key (`id`) to the `family_numbers` table for clarity and easier identification of each entry.
  - **People_id** should ideally be unique within the context of the table to avoid duplicate entries for the same person.
- **Table `types_status`**:
  - Clarified that the column `statustitle` defines a status type.
- **Table `statue`**:
  - The relationship between `people` and `types_status` is established correctly, but it may be helpful to note how the status changes over time.
  - Additional clarification regarding the update and deletion rules for statuses could be useful.

---

