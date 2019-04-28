package com.company.app.module;

import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.apache.directory.shared.ldap.ldif.*;

import java.io.*;
import java.nio.file.*;

import org.ldaptive.*;
import org.ldaptive.io.JsonWriter;

import com.fasterxml.jackson.databind.*;

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
		String dn = "cn=users,cn=bayusers";

		//iterate the entries
		for (LdifEntry entry : entries) {
		    final String name = entry.getDn().getName();
		    if (dn.equals(name)) {
		        logger.trace("{}", entry.get("cn"));
		        logger.trace("{}", entry.get("mail"));
		    }
		}
	}

	//@Test
	@Ignore
	public void shouldConvertLdiftoJson() throws Exception {

		// REF: http://www.ldaptive.org/docs/guide/formatting.html

		// Sort behavior can also be controlled by setting a JVM System property:
		// -Dorg.ldaptive.sortBehavior=ORDERED

		StringWriter writer = new StringWriter();
		JsonWriter jsonWriter = new JsonWriter(writer);

		FileReader reader = new FileReader("/path/to/entry.ldif");
		org.ldaptive.io.LdifReader ldifReader = new org.ldaptive.io.LdifReader(reader, SortBehavior.SORTED);
		SearchResult result = ldifReader.read(); // data will be sorted accordingly

/*
		SearchOperation search = new SearchOperation(conn);
		SearchResult result = search.execute(new SearchRequest("DC=BAY,DC=COM",
			                                 new SearchFilter("(uid=worawee)"),
			                                 new String[] {"mail"})).getResult();
*/

		jsonWriter.write(result);
		String jsonBeauty = beautify(writer.toString());
		logger.trace("{}", jsonBeauty);
		Files.write(Paths.get("/path/to/output.json"), jsonBeauty.getBytes());
	}

	private String beautify(String json) throws IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    Object obj = mapper.readValue(json, Object.class);
	    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

	    // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	    // JsonNode tree = mapper.readTree(json);
	    // return mapper.writeValueAsString(tree);
	}
}
