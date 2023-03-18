package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void finallyLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		if (!(args.length == 0)) {
		System.out.println("[사후 무조건 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
		} else {
			System.out.println("[사후 무조건 처리] " + method);
		}
	}
}