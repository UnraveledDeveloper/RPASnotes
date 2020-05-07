package dev.agboneni.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Aspect
public class LoggingAspect {
	
	//need to log how many times people make a request to the application
	
	private int counter = 0;
	
	//This is an advice method 
	//this will be applied before the joinpoints specified are executed
	@Before("logJP()")
	public void logInfo() {
		System.out.println("This many calls have been made to the application: " + ++counter);
	}
	
	
	//joinpoints are any methods in the application that can be advised
	//this pointcut will apply to every method in associate controller 
	@Pointcut("execution(* dev.agboneni.controller.AssociateController.*(..))")
	private void logJP() {}
}
