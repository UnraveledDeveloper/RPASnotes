package dev.agboneni.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class SecurityAspect {
	
	//want a method that reads incoming http request, check headers and make sure that
	//request contains an api key with appropriate password
	@Around("securityJP()") //@around the most poweful type of advice one can give
	//allows for interception of code and advice will run before and after the code executes
	//it can alter both input parameters and output if you choose
	public Object authenticate(ProceedingJoinPoint pip) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		String auth = request.getHeader("Authorization");
		
		if(auth != null && auth.equals("pa$$word")) {
			Object obj = pip.proceed();
			return obj;
		}else {
			response.sendError(401);
			return null;
		}
	}
	
	
	//applies to every method that has the @authorize 
	@Pointcut("@annotation(dev.agboneni.aspects.Authorized)")
	private void securityJP() {
		
	}
	
}
