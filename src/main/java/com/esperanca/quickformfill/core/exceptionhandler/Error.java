package com.esperanca.quickformfill.core.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Error (
		Integer status,
		OffsetDateTime timestamp,
		String type,
		String title,
		String detail,
		List<Field> fields
) {}