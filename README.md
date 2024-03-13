Endpoints:
POST /api/upload-test-data: Uploads test data from an Excel sheet.
POST /api/start-test: Initiates a test, providing the first question.
GET /api/get-question/{questionId}: Retrieves a specific question based on its identifier.
POST /api/redirect-user: Redirects the user to the next question based on their selected option.
POST /api/store-test-result: Stores user test results.
GET /api/get-result/{userId}/{testDateTime}: Retrieves test results for a specific user and test attempt.
GET /api/get-all-test-results: Provides access to all test results in a paginated format.

# How to Use Endpoints:

Upload Test Data:

Endpoint: POST /api/upload-test-data
Request: Upload an Excel sheet containing questions, options, and relationships.
Response: Receive confirmation or an error message.
Start Test:

Endpoint: POST /api/start-test
Request: Optionally provide user details.
Response: Receive the first question to begin the quiz.
Get Question:

Endpoint: GET /api/get-question/{questionId}
Request: Specify the unique question identifier.
Response: Obtain details of the requested question.
Redirect User:

Endpoint: POST /api/redirect-user
Request: Provide currentQuestionId and selectedOption.
Response: Get details of the next question based on the user's choice.
Store User Test Result:

Endpoint: POST /api/store-test-result
Request: Provide userId, currentQuestionId, selectedOption, and timeTaken.
Response: Receive confirmation of successful test result storage.
Get Result:

Endpoint: GET /api/get-result/{userId}/{testDateTime}
Request: Specify userId and testDateTime.
Response: Retrieve test results for the specified user and test attempt.
Get All Test Results:

Endpoint: GET /api/get-all-test-results
Request: Provide page and size for pagination.
Response: Access a paginated list of all test results.
