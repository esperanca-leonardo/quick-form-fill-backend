package com.esperanca.quickformfill.core.utils.queries.queryexecutor;

public interface QueryExecutor<ID> {

	Object findById(ID id, Class<?> entityClass);
}
