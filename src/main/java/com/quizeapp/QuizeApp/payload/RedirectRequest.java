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
public class RedirectRequest {
    private Long userId;
    private Long currentQuestionId;
    private String selectedOption;

    // Constructors, getters, setters, and other methods
}

