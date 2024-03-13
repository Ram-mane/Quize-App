package com.quizeapp.QuizeApp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test_result")
@Getter
@Setter
@NoArgsConstructor
public class TestResult {

   
    


	public TestResult( User user, TestData question, String selectedOptions
			) {
		super();
		this.user = user;
		this.question = question;
		this.selectedOptions = selectedOptions;
		this.timeTaken = timeTaken;
	}




	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
	public String toString() {
		return "TestResult [resultId=" + resultId + ", user=" + user + ", question=" + question + ", testDateTime="
				+ testDateTime + ", totalMarks=" + totalMarks + ", questionSequence=" + questionSequence
				+ ", selectedOptions=" + selectedOptions + ", timeTaken=" + timeTaken + "]";
	}




	@ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private TestData question;

    private LocalDateTime testDateTime;
    private int totalMarks;

    @Column(length = 1000)
    private String questionSequence;

    @Column(length = 1000)
    private String selectedOptions;

    private long timeTaken;

    // Constructors, getters, setters, and other methods

}

