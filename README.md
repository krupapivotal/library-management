# library-management
Spring boot Microservices

# User Service

The **User Service** is the first microservice created in this project. It provides basic **CRUD operations** for managing users. Each user can have a role, such as `"admin"` or `"user"`.

- **Service Port:** `9090`

---

## 🛠️ Features

- Create a new user
- Retrieve all users
- Get user by ID
- Get user by Role/Filter users by role
- Update user by ID
- Delete user by ID
- Error handling for invalid input (e.g., user not found, invalid role)

---

## 🔁 API Endpoints

### ➕ Create User

**POST** `/api/users`

**cURL Example:**
```bash
curl --location 'http://localhost:9090/api/users' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "user 7",
  "email": "user7@gmail.com",
  "role": "user"
}'
```
**Sample Response:**
```bash
{
  "id": 33,
  "name": "user 7",
  "email": "user7@gmail.com",
  "role": "user"
}

```

### ➕ **GET All User**

**GET** `/api/users`

**cURL Example:**
```bash
curl --location 'http://localhost:9090/api/users' \
```
**Sample Response:**
```bash
[
    {
        "id": 2,
        "name": "admin user",
        "email": "adminuser@gmail.com",
        "role": "admin"
    },
    {
        "id": 3,
        "name": "regular 1",
        "email": "regular1@gmail.com",
        "role": "user"
    }
]
```

### ➕ **Get user by ID**

**GET** `/api/users/{userId}`

**cURL Example:**
```bash
curl --location 'curl --location 'http://localhost:9090/api/users/3' \
```
**Sample Response:**
```bash
{
    "id": 3,
    "name": "regular 1",
    "email": "regular1@gmail.com",
    "role": "user"
}
```
### ➕ **Get user by Role/Filter users by role**

**GET** `/api/users/roles/{role}`

**cURL Example:**
```bash
curl --location 'curl --location 'http://localhost:9090/api/users/roles/admin' \
```
**Sample Response:**
```bash
{
    "id": 3,
    "name": "regular 1",
    "email": "regular1@gmail.com",
    "role": "admin"
}
```
**Error handling for invalid role**
```bash
curl --location 'curl --location 'http://localhost:9090/api/users/roles/xyz' \
```
**Sample Response:**
```bash
Invalid role 'xyz'. please enter correct role
```

**UPDATE** `/api/users/{userId}`

**Example:**
```bash
curl --location --request PUT 'http://localhost:9090/api/users/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "user 30",
    "email" : "user30@gmail.com",
    "role" : "user"
}'
```
**Sample Response:**
```bash
{
    "id": 3,
    "name": "user 30",
    "email": "user30@gmail.com",
    "role": "user"
}
```
**DELETE** `/api/users/{userId}`

**Example:**
```bash
curl --location --request DELETE 'http://localhost:9090/api/users/33'
```
**Sample Response:**
```bash
200 OK
```