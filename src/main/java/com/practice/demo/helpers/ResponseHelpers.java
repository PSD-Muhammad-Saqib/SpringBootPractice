package com.practice.demo.helpers;

import java.util.HashMap;
import java.util.Map;

public class ResponseHelpers {

	public static Map<String, String> notFoundResponse(String classPath, Integer id) {
		String[] paths = classPath.split("\\.");
		String className = paths[paths.length - 1];

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", className + " Not Found with Id: " + id);
		return errorResponse;
	}

}
