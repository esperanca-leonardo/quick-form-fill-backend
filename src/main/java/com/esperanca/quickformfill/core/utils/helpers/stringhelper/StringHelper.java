package com.esperanca.quickformfill.core.utils.helpers.stringhelper;

public interface StringHelper {

	boolean endsWithIgnoreCase(String text, String suffix);

	String removeSuffix(String text, String suffix) throws IllegalArgumentException;

}
