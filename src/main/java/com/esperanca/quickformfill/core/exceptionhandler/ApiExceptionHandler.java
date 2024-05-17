package com.esperanca.quickformfill.core.exceptionhandler;

import com.esperanca.quickformfill.core.exceptions.base.BusinessLogicException;
import com.esperanca.quickformfill.domain.product.exceptions.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private Error.ErrorBuilder createErrorBuilder(Integer status, ErrorType type,
                                                            String detail) {

		return Error.builder()
				.status(status)
				.detail(detail)
				.type(type.getPath())
				.title(type.getTitle())
				.timestamp(createTimestampWithZeroNanos());
	}

	private List<Field> extractFieldErrors(MethodArgumentNotValidException exception) {
		return exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(this::mapToField)
				.toList();
	}

	private Field mapToField(FieldError fieldError) {
		return Field.builder()
				.name(fieldError.getField())
				.message(fieldError.getDefaultMessage())
				.build();
	}

	private OffsetDateTime createTimestampWithZeroNanos() {
		return OffsetDateTime.now().withNano(0);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		if (isNull(body)) {
			body = Error.builder()
					.status(status.value())
					.title(status.toString())
					.timestamp(createTimestampWithZeroNanos())
					.build();
		}
		else if (body instanceof String) {
			body = Error.builder()
					.title((String) body)
					.status(status.value())
					.timestamp(createTimestampWithZeroNanos())
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {

		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		final HttpStatus STATUS = BAD_REQUEST;
		final List<Field> FIELDS = extractFieldErrors(ex);
		final var DETAIL = "One or more fields are invalid. Please fill in " +
				"the correct information and try again.";
		final var ERROR = createErrorBuilder(STATUS.value(), ErrorType.INVALID_DATA, DETAIL)
				.fields(FIELDS).build();

		return handleExceptionInternal(ex, ERROR, headers, STATUS, request);
	}

	@ExceptionHandler(BusinessLogicException.class)
	public ResponseEntity<?> handleBusinessLogic(WebRequest request,
			BusinessLogicException exception) {

		final HttpStatus STATUS = BAD_REQUEST;
		final var ERROR = createErrorBuilder(STATUS.value(), ErrorType.BUSINESS_LOGIC,
				exception.getMessage()
		).build();

		return handleExceptionInternal(exception, ERROR, new HttpHeaders(),
				STATUS, request
		);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handleProductNotFound(WebRequest request,
			ProductNotFoundException exception) {

		final HttpStatus STATUS = NOT_FOUND;
		final var ERROR = createErrorBuilder(STATUS.value(), ErrorType.PRODUCT_NOT_FOUND,
				exception.getMessage()
		).build();

		return handleExceptionInternal(exception, ERROR, new HttpHeaders(),
				STATUS, request
		);
	}
}
