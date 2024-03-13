package com.quizeapp.QuizeApp.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizeapp.QuizeApp.model.TestData;
import com.quizeapp.QuizeApp.model.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {

	@Query("SELECT tr FROM TestResult tr WHERE tr.user.id = :userId")
    Optional<TestResult> findTestResultByUserId(Long userId);
    // You can add custom queries or methods if needed

}

