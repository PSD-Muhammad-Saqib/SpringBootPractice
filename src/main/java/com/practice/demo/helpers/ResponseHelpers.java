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
	
	public static Map<String, String> notFoundResponse(String classPath1, Integer id1, String classPath2, Integer id2) {
		String[] paths1 = classPath1.split("\\.");
		String parent = paths1[paths1.length - 1];

		String[] paths2 = classPath2.split("\\.");
		String child = paths2[paths2.length - 1];

		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", parent + " with Id: " + id1 + " has No " + child + " with Id: " + id2);
		return errorResponse;
	}

}
