package com.esperanca.quickformfill.core.aspects.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AspectWrapper {

	private Class<?> entityClass;
	private Class<?> exceptionClass;
}
