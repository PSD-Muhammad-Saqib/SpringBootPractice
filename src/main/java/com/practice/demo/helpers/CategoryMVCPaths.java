package com.practice.demo.helpers;

public class CategoryMVCPaths {
	private static String CATEGORY_HOME_PATH = "categories";
	
	public static String redirect() {
		return String.format("redirect:/%s", CATEGORY_HOME_PATH);
	}
	
	public static String redirect(Integer id) {
		return String.format("redirect:/%s/%d", CATEGORY_HOME_PATH, id);
	}
	
	public static String getAllCategoriesPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "index");
	}
	
	public static String getViewCategoryPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "view");
	}
	
	public static String getAddCategoryPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "add");
	}
	
	public static String getEditCategoryPath() {
		return String.format("%s/%s", CATEGORY_HOME_PATH, "edit");
	}
}
