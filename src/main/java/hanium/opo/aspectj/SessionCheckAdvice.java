package hanium.opo.aspectj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * ��������üũ Advice
 */
@Service
@Aspect
public class SessionCheckAdvice {
	
	@Around("execution(public * hanium.opo.controller.*Board*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		Object methodParams[] = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)methodParams[0];
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			//�����߻�
			request.setAttribute("message", "�α����ϼ���!");
			throw new Exception();
		}
		Object obj = joinPoint.proceed();
		
		return obj;
	}
}
