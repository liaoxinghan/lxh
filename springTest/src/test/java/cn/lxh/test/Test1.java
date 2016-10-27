package cn.lxh.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import cn.lxh.service.TestService;

//@Configuration
//@RunWith(SpringJUnit4ClassRunner.class)
//@PropertySources(value = {@PropertySource("classpath:test/test.properties")})
//@ContextConfiguration(locations = { "classpath:test/spring.xml" })
public class Test1 {

	@Autowired
	Environment environment;

	@Value("${packge}")
	String pack;

	@Autowired
	ApplicationContext ctx;

	@Autowired
	@Qualifier("testServiceImpl")
	TestService testService;

	//	@org.junit.Test
	public void testAspect() {
		//		TestService testService = (TestService)ctx.getBean(TestService.class);
		//		Environment environment = ctx.getEnvironment();
		System.out.println(ctx.getClass().getName());
		Resource resource = ctx.getResource("classpath:test/test.properties");
		Properties p = new Properties();
		try {
			p.load(resource.getInputStream());
			System.out.println(p.get("packge") + "---" + p.getProperty("xmlName"));
			System.out.println(resource.getFilename() + "URL:" + resource.getURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != environment) {
			String[] activeProfiles = environment.getActiveProfiles();
			for (String string : activeProfiles) {
				System.out.println("profiles-active:" + string);
			}

			String[] defaultProfiles = environment.getDefaultProfiles();
			for (String string : defaultProfiles) {
				System.out.println("profiles-default:" + string);
			}
			System.out.println(environment.getProperty("packge"));

			System.out.println(pack);
		}
		testService.search(1);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public static void main(String[] args) {
		System.out.println("按时打算ss");
		
	}
}
