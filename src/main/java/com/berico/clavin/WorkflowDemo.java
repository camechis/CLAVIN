package com.berico.clavin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.berico.clavin.extractor.LocationExtractor;
import com.berico.clavin.resolver.LocationResolver;
import com.berico.clavin.resolver.ResolvedLocation;
import com.berico.clavin.util.TextUtils;

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
 * WorkflowDemo.java
 * 
 *###################################################################*/

/**
 * Quick example showing how to use CLAVIN's capabilities.
 * 
 */
public class WorkflowDemo {

	/**
	 * Run this after installing & configuring CLAVIN to get a sense of
	 * how to use it.
	 * 
	 * @param args				not used
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {
		
		// Instantiate a LocationExtractor to extract location names
		// from text using named entity recognition (NER)
		LocationExtractor extractor = new LocationExtractor();
		
		// Unstructured text file about Somalia to be geo-tagged
		File inputFile = new File("src/test/resources/sample-docs/Somalia-doc.txt");
		
		// First, grab the contents of the text file as a String
		String inputString = TextUtils.fileToString(inputFile);

		// Then, extract location names from the unstructured text
		List<String> locationNames = extractor.extractLocationNames(inputString);
		
		// Display the location names extracted from the text
		System.out.println("Location names extracted from document:");
		for (String location : locationNames)
			System.out.println(location);
		System.out.println();
		
		/*
		 * Now we take it a step further and resolve the location
		 * names into geographic entities intended by the document's
		 * author by finding the best match in our gazetteer.
		 */
		
		// Load the Lucene index built from the GeoNames gazetteer
		File indexDirectory = new File("./IndexDirectory");
		
		// Instantiate a LocationResolver to resolve the extracted
		// location names into geographic entities, using a maxHitDepth
		// of 3 and a maxContextWindow of 5 for context-based heuristic
		// matching, and with fuzzy matching turned on.
		LocationResolver resolver = new LocationResolver(indexDirectory, 3, 5, true);
		
		// Please enjoy this status message while you wait...
		System.out.println("Resolving location names into geographic entities...");
		
		// Resolve the location names extracted from the text
		List<ResolvedLocation> resolvedLocations = resolver.resolveLocations(locationNames);
		
		// Display the ResolvedLocations found for the location names
		for (ResolvedLocation resolvedLocation : resolvedLocations)
			System.out.println(resolvedLocation);
		
		// And we're done...
		System.out.println("\n\"That's all folks!\"");
	}
}
