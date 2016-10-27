package cn.lxh.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;

/**
* <p>Title: TestReflection</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-9-28
*/
public class TestReflection {

	//	@org.junit.Test
	public void invokeMethod() {
		TestReflection testReflection = new TestReflection();
		Method method = ReflectionUtils.findMethod(TestReflection.class, "demo", Object.class);
		try {
			method.invoke(testReflection, new Object(), "thanks");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void demo(String value, Object o) {
		System.out.println("invoking");
	}
}
