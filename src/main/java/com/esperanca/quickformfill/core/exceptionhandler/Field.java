package com.esperanca.quickformfill.core.exceptionhandler;

import lombok.Builder;

@Builder
public record Field(String name, String message) { }
