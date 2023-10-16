package com.practice.demo.helpers;

public class SupplierMVCPaths {
	private static String SUPPLIER_HOME_PATH = "suppliers";
	
	public static String redirect() {
		return String.format("redirect:/%s", SUPPLIER_HOME_PATH);
	}
	
	public static String redirect(Integer id) {
		return String.format("redirect:/%s/%d", SUPPLIER_HOME_PATH, id);
	}

	
	public static String getAllSuppliersPath() {
		return String.format("%s/%s", SUPPLIER_HOME_PATH, "index");
	}
	
	public static String getViewSupplierPath() {
		return String.format("%s/%s", SUPPLIER_HOME_PATH, "view");
	}
	
	public static String getSaveSupplierPath() {
		return String.format("%s/%s", SUPPLIER_HOME_PATH, "save");
	}

}
