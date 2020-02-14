package com.navtech.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class LoggingAspects {

	/* Step: 1. // Setup the Logger Service To Perform Logging */
	private Logger logger = Logger.getLogger(getClass().getName());

	/* Step: 2. // Setup Point cuts Declarations */

	// For all the Methods of all the Class In Controllers
	@Pointcut("execution(* com.navtech.controllers.*.*(..))")
	public void forControllerPackages() {
	}

	// For all the Methods of all the Class In DTOs
	@Pointcut("execution(* com.navtech.dto.*.*(..))")
	public void forDTOPackages() {
	}

	// For all the Methods of all the Class In Services
	@Pointcut("execution(* com.navtech.service.*.*(..))")
	public void forServicePackages() {
	}

	// For all the Methods of all the Class In Services
	@Pointcut("execution(* com.navtech.dao.*.*(..))")
	public void forDAOPackages() {
	}

	@Pointcut("forControllerPackages() || forDTOPackages() || forServicePackages() || forDAOPackages()")
	public void forAppFlow() {
	}

	/* Step: 3. // Adding @Before Advice to Logged before Request */

	@Before("forAppFlow()")
	public void BeforeRequestLogging(JoinPoint joinPoint) {

		// get the Method Signature Which is to Be Called
		String methodCalled = joinPoint.getSignature().toShortString();

		// Logged it on console
		logger.info("Calling :: " + methodCalled);
	}

	/*
	 * Step: 4. // Adding @After Returning Advice to Perform Logging after Returning
	 * the Request
	 */

	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void AfterRequestSuccessLogging(JoinPoint joinPoint, Object result) {

		// get the Method Signature which is Called is Successfully Finish
		String methodCalled = joinPoint.getSignature().toShortString();

		// Logged it on Console With the Result
		logger.info("::Successfully Executed::" + methodCalled);
		logger.info("Result :: " + result);
	}

	@AfterThrowing(pointcut = "forAppFlow()", throwing = "exception")
	public void AfterRequestFailedLogging(JoinPoint joinPoint, Throwable exception) {
		
		// get the Method Signature which is Called is Successfully Finish
		String methodCalled = joinPoint.getSignature().toShortString();

		// Logged it on Console With the Result
		logger.info(exception + " Occured at " + methodCalled);
	}
	
	// Note:: 
	// 	1.Other Then That There are two more types of Advices which are::
	//			1. After Annotation Advice
	//			2. Around Annotation Advice
	//	2.Other Then That More Aspects are Created and Order Management is done Later.
	
	//This is to be done later

}
