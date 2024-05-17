package com.esperanca.quickformfill.core.utils.queries.querymanager;

import com.esperanca.quickformfill.core.utils.queries.queryexecutor.QueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryManagerImpl implements QueryManager<Long> {

	@Autowired
	private QueryExecutor<Long> queryExecutor;

	@Override
	public Object findById(Long id, Class<?> entityClass) {
		return this.queryExecutor.findById(id, entityClass);
	}
}
