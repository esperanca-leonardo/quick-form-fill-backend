package com.esperanca.quickformfill.core.aspects.logic;

import com.esperanca.quickformfill.core.aspects.model.AspectWrapper;
import com.esperanca.quickformfill.core.exceptions.enums.ExceptionType;
import com.esperanca.quickformfill.core.utils.helpers.aspecthelper.AspectHelper;
import com.esperanca.quickformfill.core.utils.helpers.pathhelper.PathHelper;
import com.esperanca.quickformfill.core.utils.helpers.reflectionhelper.ReflectionHelper;
import com.esperanca.quickformfill.core.utils.helpers.stringhelper.StringHelper;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonAspectLogicImpl implements CommonAspectLogic {

	@Autowired
	private PathHelper pathHelper;

	@Autowired
	private AspectHelper aspectHelper;

	@Autowired
	private StringHelper stringHelper;

	@Autowired
	private ReflectionHelper reflectionHelper;

	@Override
	public AspectWrapper getClasses(JoinPoint joinPoint,
			ExceptionType exceptionType) throws ClassNotFoundException {

		final Class<?> entityClass = this.getEntityClass(joinPoint);

		final String entityClassName = this.getEntityClassNameWithoutSuffix(joinPoint);
		final Class<?> exceptionClass = this.getExceptionClass(entityClassName, exceptionType);

		return new AspectWrapper(entityClass, exceptionClass);
	}

	@Override
	public Class<?> getEntityClass(JoinPoint joinPoint) throws ClassNotFoundException {
		final String entityClassNameWithoutSuffix = this.getEntityClassNameWithoutSuffix(joinPoint);
		final String entityClassPath = this.pathHelper.getEntityPath(entityClassNameWithoutSuffix);

		return this.reflectionHelper.getClassFromPath(entityClassPath);
	}

	@Override
	public String getEntityClassNameWithoutSuffix(JoinPoint joinPoint) {
		final String entityClassSimpleName = this.aspectHelper.getClassSimpleName(joinPoint);
		return this.stringHelper.removeSuffix(entityClassSimpleName, "CrudControllerImpl");
	}

	@Override
	public Class<?> getExceptionClass(String entityClassName,
			ExceptionType exceptionType) throws ClassNotFoundException {

		final String exceptionClassPath = this.pathHelper.getExceptionPath(entityClassName, exceptionType);
		return this.reflectionHelper.getClassFromPath(exceptionClassPath);
	}
}
