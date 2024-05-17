package com.esperanca.quickformfill.core.utils.helpers.reflectionhelper;

import java.lang.reflect.Field;

public interface ReflectionHelper {

	Field getField(Class<?> aClass, String fieldName) throws NoSuchFieldException;

	Class<?> getClassFromPath(String classPath) throws ClassNotFoundException;
}
