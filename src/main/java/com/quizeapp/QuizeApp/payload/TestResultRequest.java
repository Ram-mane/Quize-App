package com.quizeapp.QuizeApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class TestResultRequest {
    private Long userId;
    private Long currentQuestionId;
    private String selectedOption;
    private long timeTaken;

    // Constructors, getters, setters, and other methods
}

