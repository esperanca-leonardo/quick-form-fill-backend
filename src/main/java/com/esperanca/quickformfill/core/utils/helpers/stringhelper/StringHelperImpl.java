package com.esperanca.quickformfill.core.utils.helpers.stringhelper;

import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class StringHelperImpl implements StringHelper {

	@Override
	public boolean endsWithIgnoreCase(String text, String suffix) {
		final String textInLowerCase = text.toLowerCase();
		final String suffixInLowerCase = suffix.toLowerCase();

		return textInLowerCase.endsWith(suffixInLowerCase);
	}

	@Override
	public String removeSuffix(String text, String suffix)
			throws IllegalArgumentException {

		final String messageError = format(
				"The suffix '%s' is not present in the text: '%s'",
				suffix, text
		);
		if (!this.endsWithIgnoreCase(text, suffix)) {
			throw new IllegalArgumentException(messageError);
		}
		final int lengthWithoutSuffix = text.length() - suffix.length();
		return text.substring(0, lengthWithoutSuffix);
	}
}
