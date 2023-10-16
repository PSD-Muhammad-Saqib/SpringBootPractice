package com.practice.demo.helpers;

public class ProductMVCPaths {
	private static final String PRODUCT_HOME_PATH = "products";
	
	public static String redirect() {
		return String.format("redirect:/%s", PRODUCT_HOME_PATH);
	}
	
	public static String redirect(Integer id) {
		return String.format("redirect:/%s/%d", PRODUCT_HOME_PATH, id);
	}

	
	public static String getAllProductsPath() {
		return String.format("%s/%s", PRODUCT_HOME_PATH, "index");
	}
	
	public static String getViewProductPath() {
		return String.format("%s/%s", PRODUCT_HOME_PATH, "view");
	}
	
	public static String getSaveProductPath() {
		return String.format("%s/%s", PRODUCT_HOME_PATH, "save");
	}

}
