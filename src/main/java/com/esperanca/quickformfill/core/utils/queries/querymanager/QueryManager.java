package com.esperanca.quickformfill.core.utils.queries.querymanager;

public interface QueryManager<ID> {

	Object findById(ID id, Class<?> entityClass);
}
