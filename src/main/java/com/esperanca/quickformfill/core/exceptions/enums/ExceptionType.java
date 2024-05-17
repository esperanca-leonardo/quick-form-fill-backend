package com.esperanca.quickformfill.core.exceptions.enums;

import lombok.Getter;

@Getter
public enum ExceptionType {
	NOT_FOUND("NotFoundException");

	private final String value;

	ExceptionType(String value) {
		this.value = value;
	}
}
