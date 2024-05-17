package com.esperanca.quickformfill.core.aspects.logic;

import com.esperanca.quickformfill.core.aspects.model.AspectWrapper;
import com.esperanca.quickformfill.core.exceptions.enums.ExceptionType;
import org.aspectj.lang.JoinPoint;

public interface CommonAspectLogic {

	AspectWrapper getClasses(JoinPoint joinPoint, ExceptionType exceptionType)
			throws ClassNotFoundException;

	Class<?> getEntityClass(JoinPoint joinPoint) throws ClassNotFoundException;

	String getEntityClassNameWithoutSuffix(JoinPoint joinPoint);

	Class<?> getExceptionClass(String entityClassName, ExceptionType exceptionType)
			throws ClassNotFoundException;
}
