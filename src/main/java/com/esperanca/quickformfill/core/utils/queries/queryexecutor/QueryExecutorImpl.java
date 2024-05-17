package com.esperanca.quickformfill.core.utils.queries.queryexecutor;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryExecutorImpl implements QueryExecutor<Long> {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Object findById(Long id, Class<?> entityClass) {
		return entityManager.find(entityClass, id);
	}
}
