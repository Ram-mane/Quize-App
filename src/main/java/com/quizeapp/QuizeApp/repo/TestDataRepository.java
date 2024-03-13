package com.quizeapp.QuizeApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeapp.QuizeApp.model.TestData;

public interface TestDataRepository extends JpaRepository<TestData, Long> {

    // You can add custom queries or methods if needed

}

