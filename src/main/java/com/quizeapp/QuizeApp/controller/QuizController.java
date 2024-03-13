package com.quizeapp.QuizeApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.quizeapp.QuizeApp.Utils.ExcelParser;
import com.quizeapp.QuizeApp.model.TestData;
import com.quizeapp.QuizeApp.model.TestResult;
import com.quizeapp.QuizeApp.model.User;
import com.quizeapp.QuizeApp.payload.ApiResponse;
import com.quizeapp.QuizeApp.payload.RedirectRequest;
import com.quizeapp.QuizeApp.payload.TestResultRequest;
import com.quizeapp.QuizeApp.repo.TestDataRepository;
import com.quizeapp.QuizeApp.services.QuizService;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService quizService;
    

    @PostMapping("/")
    public ResponseEntity<?> uploadTestData(@RequestParam("file") MultipartFile file) {
        try {
            List<List<String>> excelData = ExcelParser.parseExcel(file);
            // Convert excelData to TestData objects and save to the database
            // ...
            
            for (int i = 1; i < excelData.size(); i++) {
                List<String> rowData = excelData.get(i);

                TestData testData = new TestData();
                testData.setQuestion(rowData.get(1).trim());
                testData.setOption1(rowData.get(2).trim());
                testData.setOption2(rowData.get(3).trim());
                testData.setOption3(rowData.get(4).trim());
                testData.setOption4(rowData.get(5).trim());
                testData.setNextQuestionOption1(Long.parseLong(rowData.get(6).replace(".0", "").trim()));
                testData.setNextQuestionOption2(Long.parseLong(rowData.get(7).replace(".0", "").trim()));
                testData.setNextQuestionOption3(Long.parseLong(rowData.get(8).replace(".0", "").trim()));
                testData.setNextQuestionOption4(Long.parseLong(rowData.get(9).replace(".0", "").trim()));

                // Save to the database
                quizService.uploadTestData(testData);
            }
            
            
            
            ApiResponse response = new ApiResponse("Test data uploaded successfully",excelData);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload test data");
        }
    }

    @PostMapping("/starttest")
    public ResponseEntity<TestData> startTest(@RequestBody User user) {
        User savedUser = quizService.saveUser(user);
        // Fetch the first question from the database
        TestData firstQuestion = quizService.getQuestionById(1L);  

        return ResponseEntity.ok(firstQuestion);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<TestData> getQuestion(@PathVariable Long questionId) {
        TestData question = quizService.getQuestionById(questionId);

        return ResponseEntity.ok(question);
    }

    @PostMapping("/redirect")
    public ResponseEntity<TestData> redirectUser(@RequestBody RedirectRequest redirectRequest) {
        TestData nextQuestion = quizService.getNextQuestion(redirectRequest.getCurrentQuestionId(), redirectRequest.getSelectedOption());

        User user = quizService.saveUser(new User(redirectRequest.getUserId()));
        System.out.println("user "+ user);
        TestData currentQuestion = quizService.getQuestionById(redirectRequest.getCurrentQuestionId());
        quizService.storeTestResult(user, currentQuestion, redirectRequest.getSelectedOption());

        
        return ResponseEntity.ok(nextQuestion);
    }

    @PostMapping("/storeresult")
    public ResponseEntity<String> storeTestResult(@RequestBody TestResultRequest testResultRequest) {
        User user = quizService.saveUser(new User(testResultRequest.getUserId()));
        TestData currentQuestion = quizService.getQuestionById(testResultRequest.getCurrentQuestionId());
        quizService.storeTestResult(user, currentQuestion, testResultRequest.getSelectedOption());

        return ResponseEntity.ok("Test result stored successfully");
    }

    @GetMapping("/getResult/{userId}")
    public ResponseEntity<TestResult> getResult(@PathVariable Long userId) {
        TestResult result = quizService.getResultById(userId);
        
        

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TestResult>> getAllTestResults() {
        List<TestResult> testResults = quizService.getAllTestResults();

        return ResponseEntity.ok(testResults);
    }

}

