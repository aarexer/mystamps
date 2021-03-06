/*
 * Copyright (C) 2009-2018 Slava Semushin <slava.semushin@gmail.com>
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
package ru.mystamps.web.tests.cases;

import org.openqa.selenium.support.PageFactory;

import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import ru.mystamps.web.tests.WebDriverFactory;
import ru.mystamps.web.config.TestContext;
import ru.mystamps.web.tests.page.AbstractPage;

@ContextConfiguration(
	loader = AnnotationConfigContextLoader.class,
	initializers = ConfigFileApplicationContextInitializer.class,
	classes = TestContext.class
)
@SuppressWarnings("checkstyle:abstractclassname")
abstract class WhenAnyUserAtAnyPage<T extends AbstractPage>
	extends AbstractTestNGSpringContextTests {
	
	protected final T page;
	
	WhenAnyUserAtAnyPage(Class<T> pageClass) {
		super();
		page = PageFactory.initElements(WebDriverFactory.getDriver(), pageClass);
	}
	
}
