# Upload Test Data

 Endpoint: POST /api/
Use Case: Allows users to upload test data in the form of an Excel sheet. The Excel sheet is parsed, and the data is converted to TestData objects, which are then saved to the database.
Start Test

 Endpoint: POST /api/starttest
Use Case: Initiates a test for a user. It saves the user information (if not already saved) and retrieves the first question from the database to kickstart the quiz-taking journey.
Get Question

 Endpoint: GET /api/question/{questionId}
Use Case: Retrieves a specific question based on its unique identifier (questionId). This allows users to see and answer individual questions during the quiz.
Redirect User

 Endpoint: POST /api/redirect
Use Case: Handles the redirection of users based on their selected option. After a user answers a question, this endpoint calculates the next question and stores the user's response and the current question in the database.
Store Test Result

 Endpoint: POST /api/storeresult
Use Case: Stores the test result for a specific user after answering a question. It saves the user's response to a question along with the question and user information in the database.
Get Result

 Endpoint: GET /api/getResult/{userId}
Use Case: Retrieves the test result for a specific user based on their userId. This allows users to review their performance in a previous quiz.
Get All Test Results

# Endpoint: GET /api/getall
Use Case: Provides access to all test results in a paginated format. Results are sorted by the latest date, allowing users to analyze their progress over time.
