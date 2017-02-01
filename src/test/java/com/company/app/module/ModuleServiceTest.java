package com.company.app.module;

import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.apache.directory.shared.ldap.ldif.*;

import java.io.*;
import org.ldaptive.*;
import org.ldaptive.io.JsonWriter;

public class ModuleServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(ModuleService.class);

	@Test
	public void shouldSayHello() {
		new ModuleService().sayHello("Jun");
	}

	@Ignore
	public void shouldParseLdif() throws Exception {

		LdifReader reader = new LdifReader();
		List<LdifEntry> entries = reader.parseLdifFile("/path/to/entry.ldif");
		String dn = "cn=Michael Owen,mail=xyz@mail.com";

		//iterate the entries
		for (LdifEntry entry : entries) {
		    final String name = entry.getDn().getName();
		    if (dn.equals(name)) {
		        logger.trace("{}", entry.get("cn"));
		        logger.trace("{}", entry.get("mail"));
		    }
		}
	}

	@Ignore
	public void shouldSearchLdiftoJson() throws Exception {

		// REF: http://www.ldaptive.org/docs/guide/formatting.html

		// Sort behavior can also be controlled by setting a JVM System property:
		// -Dorg.ldaptive.sortBehavior=ORDERED
		
		StringWriter writer = new StringWriter();
		JsonWriter jsonWriter = new JsonWriter(writer);

		FileReader reader = new FileReader("/path/to/entry.ldif");
		org.ldaptive.io.LdifReader ldifReader = new org.ldaptive.io.LdifReader(reader, SortBehavior.SORTED);
		SearchResult result = ldifReader.read(); // data will be sorted accordingly

		jsonWriter.write(result);
        logger.trace("{}", writer);
	}
	
}
