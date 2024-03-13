package com.quizeapp.QuizeApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeapp.QuizeApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // You can add custom queries or methods if needed

}

