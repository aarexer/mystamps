/*
 * Copyright (C) 2009-2017 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.qala.datagen.RandomShortApi;

import ru.mystamps.web.validation.ValidationRules;

import static io.qala.datagen.RandomShortApi.integer;
import static io.qala.datagen.RandomShortApi.sample;
import static io.qala.datagen.RandomShortApi.sampleMultiple;
import static io.qala.datagen.RandomValue.between;
import static io.qala.datagen.StringModifier.Impls.multipleOf;
import static io.qala.datagen.StringModifier.Impls.oneOf;

public final class Random {
	
	// TODO: use constants for statuses
	private static final String[] STATUSES = new String[] {
		"Unprocessed",
		"DownloadingSucceeded",
		"DownloadingFailed",
		"ParsingSucceeded",
		"ParsingFailed",
		"ImportSucceeded",
	};
	
	private Random() {
	}
	
	public static Integer id() {
		return RandomShortApi.positiveInteger();
	}
	
	public static Integer userId() {
		return RandomShortApi.positiveInteger();
	}
	
	public static String url() {
		final long minLength = 5;
		final long maxLength = 15;
		String randomPart = between(minLength, maxLength).with(multipleOf('/')).alphanumeric();
		return "http://example.com/page/" + randomPart;
	}
	
	public static String lang() {
		return sample("en", "de", "fr", "ru");
	}
	
	public static String categoryName() {
		return between(
				ValidationRules.CATEGORY_NAME_MIN_LENGTH,
				ValidationRules.CATEGORY_NAME_MAX_LENGTH
			)
			.with(oneOf(" -"))
			.english();
	}
	
	public static String countryName() {
		return between(
				ValidationRules.COUNTRY_NAME_MIN_LENGTH,
				ValidationRules.COUNTRY_NAME_MAX_LENGTH
			)
			.with(oneOf(" -"))
			.english();
	}
	
	public static String importRequestStatus() {
		return sample(STATUSES);
	}
	
	public static List<String> importRequestStatuses(int numToReturn) {
		return sampleMultiple(numToReturn, STATUSES);
	}
	
	public static Set<String> setOfStrings() {
		final int minSize = 1;
		final int maxSize = 3;
		int size = integer(minSize, maxSize);
		return new HashSet<>(sampleMultiple(size, "foo", "bar", "baz"));
	}
	
	public static List<Integer> listOfIntegers() {
		final int minSize = 1;
		final int maxSize = 3;
		int size = integer(minSize, maxSize);
		return sampleMultiple(size, integer(), integer(), integer());
	}
	
}
