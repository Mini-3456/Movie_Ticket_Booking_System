# Movie Ticket Booking System (Hibernate ORM)
A comprehensive Java application demonstrating the implementation of **Hibernate ORM** to manage a movie theater database. 
This project showcases the flexibility of Hibernate by implementing database interactions through three distinct approaches: 
standard Session methods, Hibernate Query Language (HQL), and Native SQL.

## 🚀 Key Features
  **Entity Mapping**: Uses Jakarta Persistence (JPA) annotations for mapping Java objects to MySQL tables.
  
  **Automatic Schema Generation**: Leverages Hibernate's `hbm2ddl` to generate table structures automatically.
  
  **Multiple Querying Techniques**:
  
   **Standard CRUD**: Basic persistence operations using `persist()`, `merge()`, and `remove()`.
      
   **HQL (Hibernate Query Language)**: Object-oriented queries including aggregations (`max`, `avg`) and sorting.
      
   **Native SQL**: Direct database communication for complex operations like `JOIN` queries.

## 🛠️ Project Structure
The project is organized into clear packages following industry standards:
| Package         | Purpose |
| :---            | :--- |
| **com.entity**  | JPA Entity classes (`Movie.java`, `Booking.java`) representing the database tables. |
| **com.utility** | Utility class for managing the `SessionFactory` singleton. |
| **com**         | Execution classes for testing HQL, Native SQL, and standard CRUD logic. |

## 📊 Database Schema
The application manages two primary entities. Hibernate handles the creation of these tables based on the following attributes:
### 1. Movie Entity
- `movieId`: Primary Key (Identity)
- `title`: String
- `genre`: String
- `rating`: Double
- `ticketPrice`: Double
  
### 2. Booking Entity
- `bookingId`: Primary Key (Identity)
- `customerName`: String
- `movieId`: Integer (Foreign reference)
- `numberOfTickets`: Integer
- `totalAmount`: Double

## 💻 Tech Stack
  **Language**: Java(JDK 22)
  
  **Framework**: Hibernate(7.0.8.Final)
  
  **Database**: MySQL
  
  **Build Tool**: Maven
  
  **IDE**: Eclipse
  
## 🏗️ Design Patterns & Architecture
 **Singleton Pattern**: Implemented in `HibernateUtil` to ensure a single `SessionFactory` instance, optimizing resource utilization.
 
 **Data Access Logic**: Separated business logic from data persistence, demonstrating a clean, maintainable architecture.
 
 **Object-Relational Mapping (ORM)**: Leveraged JPA annotations to bridge the gap between Java's object-oriented model and MySQL's relational model.
