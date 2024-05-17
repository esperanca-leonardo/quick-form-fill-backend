package com.esperanca.quickformfill.core.utils.helpers.pathhelper;

import com.esperanca.quickformfill.core.exceptions.enums.ExceptionType;

public interface PathHelper {

	String getEntityPath(String className);

	String getExceptionPath(String className, ExceptionType exceptionType);
}
