package poc;

import net.sf.uadetector.service.UADetectorServiceFactory;
import ua_parser.Client;
import ua_parser.Parser;
import net.sf.uadetector.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentTest {
 
	private static final Logger logger = LoggerFactory.getLogger(UserAgentTest.class);

	private static String UA_STRING_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";
	private static String UA_STRING_2 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3800.0 Safari/537.36 Edg/76.0.167.0";
	private static String UA_STRING_3 = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3";
	private static String UA_STRING_4 = "Mozilla/5.0 (Linux; Android 6.0.1; MI 5s Build/MXB48T; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36 Line/7.3.0";

	@Test
	public void testUaParser() throws Exception {
		uaParser(UA_STRING_1);
		uaParser(UA_STRING_2);
		uaParser(UA_STRING_3);
		uaParser(UA_STRING_4);
	}

	private void uaParser(String ua) throws Exception {

		Parser uaParser = new Parser();
		Client c = uaParser.parse(ua);

		logger.debug("UA: {}", ua);
		logger.debug("Device    : {}", c.device.family);    // => "iPhone"
		logger.debug("UA family : {}", c.userAgent.family); // => "Mobile Safari"
		logger.debug("UA major  : {}", c.userAgent.major);  // => "5"
		logger.debug("UA minor  : {}", c.userAgent.minor);  // => "1"
		logger.debug("OS family : {}", c.os.family);        // => "iOS"
		logger.debug("OS major  : {}", c.os.major);         // => "5"
		logger.debug("OS minor  : {}\n", c.os.minor);        // => "1"
	}

	@Test
	public void testUaDetector() throws Exception {
		uaDetector(UA_STRING_1);
		uaDetector(UA_STRING_2);
		uaDetector(UA_STRING_3);
		uaDetector(UA_STRING_4);
	}

	private void uaDetector(String ua) throws Exception {

		// Get an UserAgentStringParser and analyze the requesting client
		UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
		ReadableUserAgent agent = parser.parse(ua);
 
		logger.debug("{}", ua);
		logger.debug("{}", agent.getDeviceCategory());
		logger.debug("{}", agent.getFamily());
		logger.debug("{}", agent.getIcon());
		logger.debug("{}", agent.getOperatingSystem());
		logger.debug("{}", agent.getProducer());
		logger.debug("{}", agent.getProducerUrl());
		logger.debug("{}", agent.getType());
		logger.debug("{}", agent.getTypeName());
		logger.debug("{}", agent.getUrl());
		logger.debug("{}", agent.getVersionNumber());
		logger.debug("{}\n", agent.getOperatingSystem().getName());
	}

	@Test
	public void testUserAgent() throws Exception {
		userAgent(UA_STRING_1);
		userAgent(UA_STRING_2);
		userAgent(UA_STRING_3);
		userAgent(UA_STRING_4);
	}

	private void userAgent(String ua) throws Exception {
		UserAgent userAgent = UserAgent.parseUserAgentString(ua); // request.getHeader("User-Agent")
		logger.debug("{}", userAgent);
		logger.debug("{}", userAgent.getBrowser());
		logger.debug("{}", userAgent.getBrowserVersion());
		logger.debug("{}\n", userAgent.getOperatingSystem());
	}
}