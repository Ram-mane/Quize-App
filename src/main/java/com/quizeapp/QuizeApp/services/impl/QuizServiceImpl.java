package com.quizeapp.QuizeApp.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizeapp.QuizeApp.exceptions.QuizException;
import com.quizeapp.QuizeApp.model.TestData;
import com.quizeapp.QuizeApp.model.TestResult;
import com.quizeapp.QuizeApp.model.User;
import com.quizeapp.QuizeApp.repo.TestDataRepository;
import com.quizeapp.QuizeApp.repo.TestResultRepository;
import com.quizeapp.QuizeApp.repo.UserRepository;
import com.quizeapp.QuizeApp.services.QuizService;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestDataRepository testDataRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public TestData uploadTestData(TestData testData) {
        // Implement logic to upload test data
        return testDataRepository.save(testData);
    }

    @Override
    public TestData getQuestionById(Long questionId) {
        return testDataRepository.findById(questionId)
                .orElseThrow(() -> new QuizException("Question not found"));
    }

    @Override
    public TestData getNextQuestion(Long currentQuestionId, String selectedOption) {
        TestData currentQuestion = testDataRepository.findById(currentQuestionId)
                .orElseThrow(() -> new QuizException("Question not found"));

        // Determine the next question based on the selected option
        Long nextQuestionId;
        switch (selectedOption) {
            case "option1":
                nextQuestionId = currentQuestion.getNextQuestionOption1();
                break;
            case "option2":
                nextQuestionId = currentQuestion.getNextQuestionOption2();
                break;
            case "option3":
                nextQuestionId = currentQuestion.getNextQuestionOption3();
                break;
            case "option4":
                nextQuestionId = currentQuestion.getNextQuestionOption4();
                break;
            default:
                throw new QuizException("Invalid option");
        }

        return testDataRepository.findById(nextQuestionId)
                .orElseThrow(() -> new QuizException("Next question not found"));
    }


    @Override
    public TestResult storeTestResult(User user, TestData currentQuestion, String selectedOption) {
        // Update the user's test results
//        String questionSequence = currentQuestion.toString();
//        if (questionSequence == null) {
//            questionSequence = "option1";
//        }
//        questionSequence += currentQuestion.getQuestionId() + ",";
//        System.out.println(questionSequence) ;
//        ((TestResult) user.getTestResult()).setQuestionSequence(questionSequence);
        
        // Save the current test result
        TestResult testResult = new TestResult(user, currentQuestion,  selectedOption);
        testResultRepository.save(testResult);

        return testResult;
    }


    @Override
    public TestResult getResultById(Long userId) {
        return testResultRepository.findTestResultByUserId(userId)
                .orElseThrow(() -> new QuizException("Test result not found"));
    }

    @Override
    public List<TestResult> getAllTestResults() {
        // Implement logic to fetch all test results with pagination
        return testResultRepository.findAll();  // You may need to customize this based on your requirements
    }

    // You can add more methods as needed

}

