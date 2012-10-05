package com.berico.clavin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*#####################################################################
 * 
 * CLAVIN (Cartographic Location And Vicinity INdexer)
 * ---------------------------------------------------
 * 
 * Copyright (C) 2012 Berico Technologies
 * http://clavin.bericotechnologies.com
 * 
 * ====================================================================
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 * ====================================================================
 * 
 * AllTestsSuite.java
 * 
 *###################################################################*/

/**
 * Runs all Clavin JUnit tests.
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
	com.berico.clavin.extractor.LocationExtractorTest.class,
	com.berico.clavin.gazetteer.GeoNameTest.class,
	com.berico.clavin.index.BinarySimilarityTest.class,
	com.berico.clavin.resolver.LocationResolverTest.class,
	com.berico.clavin.resolver.LocationResolverHeuristicsTest.class,
	com.berico.clavin.util.DamerauLevenshteinTest.class,
	com.berico.clavin.util.ListUtilsTest.class,
	com.berico.clavin.util.TextUtilsTest.class
})
public class AllTestsSuite {
	// THIS CLASS INTENTIONALLY LEFT BLANK
}
