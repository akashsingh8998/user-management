package com.sapient.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class MessageAspect {


    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* com.sapient.*.*.*(..))")
    public void methods_pointcut(){}


    @Around("methods_pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnedVal=null;


        Object[] signatureArgs = joinPoint.getArgs();
        String Args="";
        for (Object signatureArg: signatureArgs) {
            Args=Args + "[" + signatureArg + "] ";
        }


        try {
            log.debug("Door-in RestController : "+ joinPoint.getSignature());
            returnedVal=joinPoint.proceed();
            log.debug("Door-out RestController : "+ joinPoint.getSignature() 
            + " : without error : returned :" + returnedVal + 
            " : with Arguments : "+Args
                    );
        } catch (Exception e) {
            log.error("Message Not Found" );
            //throw new MessageNotFoundException();
        }
        return returnedVal;
    }
}