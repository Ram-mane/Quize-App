package com.quizeapp.QuizeApp.services;



import java.util.List;

import com.quizeapp.QuizeApp.model.TestData;
import com.quizeapp.QuizeApp.model.TestResult;
import com.quizeapp.QuizeApp.model.User;

public interface QuizService {

    User saveUser(User user);

    TestData uploadTestData(TestData testData);

    TestData getQuestionById(Long questionId);
    

    TestData getNextQuestion(Long currentQuestionId, String selectedOption);

    TestResult storeTestResult(User user, TestData currentQuestion, String selectedOption);

    TestResult getResultById(Long userId);

    List<TestResult> getAllTestResults();

    // You can add more methods as needed

}

