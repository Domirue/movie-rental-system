# movie-rental-system

Movie rental system built with Spring Boot, Spring Data JPA and H2 Database that simulates a movie rental system.

## Features

The application allows users to manage:

- Movies
- Directors
- Customers
- Rentals

Each resource supports full CRUD operations.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman

## Project Structure

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
H2 Database
```

### Controllers

Handle HTTP requests and responses.

### Services

Contain business logic and application operations.

### Repositories

Provide communication with the database using Spring Data JPA.

### DTOs

Transfer data between application layers.

## Entities

### Movie

Stores information about movies:

- title
- genre
- releaseYear

### Director

Stores information about directors:

- firstName
- lastName
- birthYear

### Customer

Stores information about customers:

- firstName
- lastName
- email

### Rental

Represents a movie rental and connects:

- Movie
- Customer

Rental contains:

- rentalDate
- returnDate

## Relationships

The application uses JPA relationships:

```java
@ManyToOne
private Movie movie;

@ManyToOne
private Customer customer;
```

A single customer can have multiple rentals and a single movie can be rented multiple times.

## API Endpoints

### Movies

```http
GET    /movies
GET    /movies/{id}
POST   /movies
PUT    /movies
DELETE /movies/{id}
```

### Directors

```http
GET    /directors
GET    /directors/{id}
POST   /directors
PUT    /directors
DELETE /directors/{id}
```

### Customers

```http
GET    /customers
GET    /customers/{id}
POST   /customers
PUT    /customers
DELETE /customers/{id}
```

### Rentals

```http
GET    /rentals
GET    /rentals/{id}
POST   /rentals
PUT    /rentals
DELETE /rentals/{id}
```

## Example Rental Request

```json
{
  "rentalDate": "2026-06-01",
  "returnDate": null,
  "movieId": 1,
  "customerId": 1
}
```

## Database

The project uses the H2 in-memory database.

Data is available while the application is running and is cleared after restart.

## Author

Student project created for learning Spring Boot, REST API development, and database relationships using JPA.
