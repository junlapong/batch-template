package com.company.app.module;

import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.apache.directory.shared.ldap.ldif.*;

public class ModuleServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(ModuleService.class);

	@Test
	public void shouldSayHello() {
		new ModuleService().sayHello("Jun");
	}

	@Ignore
	public void shouldParseLdif() throws Exception {

		LdifReader reader = new LdifReader();
		List<LdifEntry> entries = reader.parseLdifFile("/path/to/export.ldif");
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
}
