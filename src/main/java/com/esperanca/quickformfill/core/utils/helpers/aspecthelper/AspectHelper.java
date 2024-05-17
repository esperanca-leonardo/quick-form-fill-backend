package com.esperanca.quickformfill.core.utils.helpers.aspecthelper;

import org.aspectj.lang.JoinPoint;

public interface AspectHelper {

	String getClassSimpleName(JoinPoint joinPoint);
}
