package cn.lxh.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.lxh.service.TestService;
import cn.lxh.service.impl.TestServiceImpl;

public class MyProxy implements InvocationHandler {

	private Object target;

	public MyProxy(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
		System.out.println("before invoke");
		Object result = method.invoke(target, arg2);
		System.out.println("after invoke");
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}

	public static void main(String[] args) {
		TestService testService = new TestServiceImpl();
		Serializable ser = new TestServiceImpl();
		MyProxy myProxy = new MyProxy(ser);
		Class<?>[] interfaces = testService.getClass().getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println(c.getName());
		}
		TestService testServiceProxy = (TestService) myProxy.getProxy();
		testServiceProxy.search(1);
	}
}
