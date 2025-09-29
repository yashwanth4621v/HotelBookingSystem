# HotelBookingSystem

A simple Java console application for hotel room booking using JDBC and MySQL.

---

## 🧩 Features

- Add rooms (type, price, availability)  
- View available rooms  
- Book a room (mark it unavailable)  
- Cancel a booking (make room available again)  
- Basic validation (e.g. cannot book a room already booked)  
- Custom exceptions (e.g. `RoomUnavailableException`, `InvalidRoomSelectionException`)

---

## 📁 Project Structure

HotelBookingSystem/
├── src/
│ ├── dao/
│ │ ├── RoomDAO.java
│ │ ├── BookingDAO.java
│ │ └── UserDAO.java
│ ├── hotel_booking_system/
│ │ ├── main/HotelBookingApp.java
│ │ ├── models/
│ │ │ ├── Room.java
│ │ │ ├── User.java
│ │ │ └── RoomBooking.java
│ │ └── exceptions/
│ │ ├── InvalidRoomSelectionException.java
│ │ └── RoomUnavailableException.java
│ └── utils/
│ └── DBUtil.java
├── .gitignore
└── README.md

yaml
Copy code

- `dao/` — Data Access Objects for room, booking, user operations  
- `models/` — Java classes that represent entities (Room, User, etc.)  
- `exceptions/` — Custom exception classes  
- `utils/DBUtil.java` — Utility for database connection setup  
- `HotelBookingApp.java` — main class that ties everything together  

---

## 🛠️ Requirements & Setup

- Java 8+  
- MySQL (or any compatible SQL database)  
- JDBC driver for MySQL (e.g. `mysql-connector-java`)  
- (Optional) IDE like Eclipse, IntelliJ

---

## 🚀 Getting Started

### 1. Clone the repository  
```bash
git clone https://github.com/yashwanth4621v/HotelBookingSystem.git
cd HotelBookingSystem
2. Set up the database
Create a database, e.g. hotel_db.

Create a table rooms:

sql
Copy code
CREATE TABLE rooms (
  room_id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(100),
  price DOUBLE,
  available BOOLEAN
);
(Optional) Add initial rooms via SQL or by running the addRoom logic in your application.

3. Configure DB credentials
In DBUtil.java (or in a properties file), set:

java
Copy code
String url = "jdbc:mysql://localhost:3306/hotel_db";
String user = "your_mysql_username";
String password = "your_mysql_password";
Important: Do not commit your real username/password to Git. Use .gitignore to skip config files.

4. Run the application
In Eclipse (or from command line), run HotelBookingApp.java.

Follow the console prompts (e.g. View rooms, Book a room, Cancel, etc.).

✅ Usage Example
pgsql
Copy code
Welcome to Hotel Booking System
1. View available rooms
2. Book room
3. Cancel booking
4. Add new room (admin)
0. Exit
You choose an option, input IDs, types or prices, etc. The program interacts with your MySQL database accordingly.

🧪 Testing and Error Handling
If you try to book a non-existent room → InvalidRoomSelectionException

If you try to book a room that’s already unavailable → RoomUnavailableException

SQL exceptions are caught and printed (you may improve logging later)

📂 Contributing
If you want to add features:

Add user login/registration

Add more room attributes (capacity, amenities)

Use a better UI (Swing, JavaFX, web)

Use ORM (Hibernate) instead of raw JDBC

Add unit tests

📜 License
You can choose a license like MIT, Apache, or whichever fits you.

🧠 Acknowledgments
Based on your Java + JDBC learning / personal project

Thanks to the JDBC tutorials & Java community

pgsql
Copy code

---

If you like, I can generate a **README.md file** ready to drop into your repo with your project-specific details (your database name, commands, etc.). Do you want me to do that for you?
::contentReference[oaicite:0]{index=0}
