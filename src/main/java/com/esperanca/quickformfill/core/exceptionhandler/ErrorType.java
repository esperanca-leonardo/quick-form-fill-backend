package com.esperanca.quickformfill.core.exceptionhandler;

import lombok.Getter;

@Getter
public enum ErrorType {
	INVALID_DATA("/invalid-data", "Invalid data"),
	BUSINESS_LOGIC("/business-logic", "Business Logic"),
	PRODUCT_NOT_FOUND("/product-not-found", "Product not found");

	private final String title;
	private final String path;

	ErrorType(String path, String title) {
		this.path = "https://quickformmfill.com.br" + path;
		this.title = title;
	}
}
