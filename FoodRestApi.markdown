# Food Data REST API

## Description
This is a Spring Boot application that provides a REST API for managing food data. It allows you to retrieve a list of foods, get details of a specific food, save a new food, and delete a food.

## Tech Stack
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Maven

## API Endpoints

### Get Food List
- URL: `/food/foodList`
- Method: GET
- Description: Retrieves a list of all foods.
- Response: JSON array of food objects.

### Get One Food
- URL: `/food/{id}`
- Method: GET
- Description: Retrieves details of a specific food.
- Path Variable:
    - `id`: Integer (ID of the food)
- Response: JSON object representing the food.

### Save Food
- URL: `/food/save`
- Method: POST
- Description: Saves a new food.
- Request Body: JSON object representing the food to be saved.
- Response: String indicating the success message.

### Delete Food
- URL: `/food/{id}`
- Method: DELETE
- Description: Deletes a food by ID.
- Path Variable:
    - `id`: Integer (ID of the food)
- Response: String indicating the success message.

## Getting Started
1. Clone the repository.
2. Open the project in your preferred IDE.
3. Build the project using Maven.
4. Run the application.
5. The API endpoints will be accessible at `http://localhost:8080`.

## License
This project is licensed under the [MIT License](LICENSE).