package com.esperanca.quickformfill.core.utils.helpers.exceptionhelper;

import java.lang.reflect.InvocationTargetException;

public interface ExceptionHelper {

	Exception getExceptionInstance(Class<?> exceptionClass, Long id)
			throws InvocationTargetException, InstantiationException,
			IllegalAccessException, NoSuchMethodException;
}
