package com.esperanca.quickformfill.core.utils.helpers.pathhelper;

import com.esperanca.quickformfill.core.exceptions.enums.ExceptionType;
import org.springframework.stereotype.Component;

@Component
public class PathHelperImpl implements PathHelper {

	public static final String DOMAIN_PACKAGE = "com.esperanca.quickformfill.domain";

	@Override
	public String getEntityPath(String className) {
		return String.format("%s.%s.entities.%s",
				DOMAIN_PACKAGE, className.toLowerCase(), className
		);
	}

	@Override
	public String getExceptionPath(String className, ExceptionType exceptionType) {
		return String.format("%s.%s.exceptions.%s", DOMAIN_PACKAGE,
				className.toLowerCase(), className.concat(exceptionType.getValue())
		);
	}
}
