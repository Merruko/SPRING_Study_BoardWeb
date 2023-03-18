package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
	
		Object obj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println(method + "()메소드 수행에 걸린 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
}