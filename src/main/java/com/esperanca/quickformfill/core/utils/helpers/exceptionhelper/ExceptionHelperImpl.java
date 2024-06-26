package com.esperanca.quickformfill.core.utils.helpers.exceptionhelper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
public class ExceptionHelperImpl implements ExceptionHelper {

	@Override
	public Exception getExceptionInstance(Class<?> exceptionClass, Long id)
			throws InvocationTargetException, InstantiationException,
			IllegalAccessException, NoSuchMethodException {

		final Constructor<?> constructor = exceptionClass.getDeclaredConstructor(Long.class);
		return (Exception) constructor.newInstance(id);
	}
}
