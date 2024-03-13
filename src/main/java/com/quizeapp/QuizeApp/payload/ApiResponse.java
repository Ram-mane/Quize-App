package com.quizeapp.QuizeApp.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private List<List<String>> excelData;
}
