package com.esperanca.quickformfill.core.utils.helpers.aspecthelper;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectHelperImpl implements AspectHelper {
	
	@Override
	public String getClassSimpleName(JoinPoint joinPoint) {
		final Object targetObject = joinPoint.getTarget();
		final Class<?> aClass = targetObject.getClass();

		return aClass.getSimpleName();
	}
}
