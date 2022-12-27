package com.example.demo;

import java.util.logging.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MyAspect {

	private static final Logger logger = Logger.getLogger(MyAspect.class.getName());
	
	@Before("execution(public * com.example.demo.controllers.UserController.*(..))")
	public void Log()
	{
//		logger.log(Level.WARNING, "Hello From AOP logger!");
	}
	
}