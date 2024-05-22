# BookingAPI

This repository contains the source code for a Booking API developed during the MinTic bootcamp (2022). The API is designed to handle booking operations and is built using modern Java technologies.

## Features

- **Booking Management**: Create, read, update, and delete bookings.
- **User Management**: Handle user authentication and authorization.
- **Room Management**: Manage room details and availability.
- **Integration**: Easily integrate with other services and systems.

## Technologies Used

- **Java**
- **Spring Boot**
- **Maven**
- **Hibernate**

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/gioakol/BookingAPI.git
   cd BookingAPI
   ```

2. **Build the project using Maven**:
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

## Usage

### API Endpoints

- **Bookings**
  - `GET /bookings`: Retrieve all bookings
  - `POST /bookings`: Create a new booking
  - `PUT /bookings/{id}`: Update a booking
  - `DELETE /bookings/{id}`: Delete a booking

- **Users**
  - `GET /users`: Retrieve all users
  - `POST /users`: Create a new user
  - `PUT /users/{id}`: Update user information
  - `DELETE /users/{id}`: Delete a user

- **Rooms**
  - `GET /rooms`: Retrieve all rooms
  - `POST /rooms`: Add a new room
  - `PUT /rooms/{id}`: Update room details
  - `DELETE /rooms/{id}`: Delete a room

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
