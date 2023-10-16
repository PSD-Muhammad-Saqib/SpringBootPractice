package com.practice.demo.helpers;

public class CategoryMVCPaths {
	private static String CATEGORY_HOME_PATH = "categories";
	
	public static String getAllCategoriesPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "index");
	}
	
	public static String getViewCategoryPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "view");
	}
	
	public static String getAddCategoryPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "add");
	}
}
