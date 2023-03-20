package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {

	@After("PointcutCommon.allPointcut()")
	public void finallyLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사후 무조건 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}