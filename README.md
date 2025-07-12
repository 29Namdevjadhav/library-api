# Library API

A simple Spring Boot RESTful API to manage a library's book catalog.

## Features

- Add, retrieve, delete books
- Update book availability
- In-memory H2 database
- Input validation

## How to Run

```bash
mvn spring-boot:run
```

Access H2 Console: http://localhost:8080/h2-console

## Sample Endpoints

- `POST /books` - Add book
- `GET /books` - List books
- `GET /books/{id}` - Get book by ID
- `DELETE /books/{id}` - Delete book
- `PATCH /books/{id}/availability?available=true` - Update availability

## Postman Collection

Import this collection in Postman to test the API:

[ LibraryAPI.postman_collection.json](LibraryAPI.postman_collection.json)
