package com.esperanca.quickformfill.core.aspects.exceptions;

import com.esperanca.quickformfill.core.aspects.logic.CommonAspectLogic;
import com.esperanca.quickformfill.core.aspects.model.AspectWrapper;
import com.esperanca.quickformfill.core.utils.helpers.exceptionhelper.ExceptionHelper;
import com.esperanca.quickformfill.core.utils.queries.querymanager.QueryManager;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static com.esperanca.quickformfill.core.exceptions.enums.ExceptionType.NOT_FOUND;
import static java.util.Objects.isNull;

@Aspect
@Component
@AllArgsConstructor
public class EntityNotFoundAspect {

    private final ExceptionHelper exceptionHelper;
    private final QueryManager<Long> queryManager;
    private final CommonAspectLogic commonAspectLogic;

    @Before("execution(* com.esperanca.quickformfill.domain.product.controller..*(..)) && args (id, ..)")
    public void verifyIfEntityExistsOrThrow(JoinPoint joinPoint, Long id) throws Exception {
        final AspectWrapper aspectWrapper = this.commonAspectLogic.getClasses(joinPoint, NOT_FOUND);
        final Class<?> entityClass = aspectWrapper.getEntityClass();
        final Class<?> exceptionClass = aspectWrapper.getExceptionClass();

        final Object objectFromDb = this.queryManager.findById(id, entityClass);
        if (isNull(objectFromDb)) {
            throw this.exceptionHelper.getExceptionInstance(exceptionClass, id);
        }
    }
}