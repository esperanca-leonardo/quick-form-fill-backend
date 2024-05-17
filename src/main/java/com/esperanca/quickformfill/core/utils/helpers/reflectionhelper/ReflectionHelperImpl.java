package com.esperanca.quickformfill.core.utils.helpers.reflectionhelper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

import static java.lang.Class.forName;
import static java.util.Objects.nonNull;

@Component
public class ReflectionHelperImpl implements ReflectionHelper {

	@Override
	public Field getField(Class<?> aClass, String fieldName) throws NoSuchFieldException {
		try {
			return aClass.getDeclaredField(fieldName);
		}
		catch (NoSuchFieldException noSuchFieldException) {
			final Class<?> superClass = aClass.getSuperclass();

			if (nonNull(superClass)) {
				return this.getField(superClass, fieldName);
			}
			else {
				throw noSuchFieldException;
			}
		}
	}

	@Override
	public Class<?> getClassFromPath(String classPath) throws ClassNotFoundException {
		return forName(classPath);
	}
}
