package cn.lxh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* cn.lxh.service.TestService.search(..))")
	public void cutPoint() {
	}

	@Before(value = "cutPoint()")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println("before..执行" + name + "..args:" + jp.getArgs()[0]);
	}

	@After("cutPoint()")
	public void after(JoinPoint jp) {
		System.out.println("after....");

	}

	@AfterThrowing(value = "cutPoint()", throwing = "e")
	public void throwing(JoinPoint jp, Throwable e) {
		System.out.println("throwing....case:" + e);
	}

	@AfterReturning(value = "cutPoint()", argNames = "result", returning = "result")
	public void returning(JoinPoint jp, Object result) {
		System.out.println("returning....result:" + result);
	}

	//	@Around("cutPoint()")
	//	public Object around(ProceedingJoinPoint pjp) {
	//		Object proceed = null;
	//		try {
	//			System.out.println("around before");
	//			proceed = pjp.proceed();
	//			System.out.println("around after");
	//		} catch (Throwable e) {
	//			// TODO Auto-generated catch block
	//			System.out.println("around error");
	//			e.printStackTrace();
	//		}
	//		System.out.println("around return");
	//		return proceed;
	//	}

}
