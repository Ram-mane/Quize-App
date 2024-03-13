package com.quizeapp.QuizeApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test_data")
@Getter
@Setter
public class TestData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    
    @JsonIgnore
    @Column(name = "next_question_option1")
    private Long nextQuestionOption1;

    @JsonIgnore
    @Column(name = "next_question_option2")
    private Long nextQuestionOption2;

    @JsonIgnore
    @Column(name = "next_question_option3")
    private Long nextQuestionOption3;

    @JsonIgnore
    @Column(name = "next_question_option4")
    private Long nextQuestionOption4;

    // Constructors, getters, setters, and other methods

}
