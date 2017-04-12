package com.dt.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RID on 2017/4/12.
 */
@Aspect
@Component
public class HttpAspect {

    private Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.dt.controller.GirlController.*(..))")
    public void log(){
    }


    @Before("log()")
    public void  doBf(){

        logger.info("11111111111111111111111111111");
    }

    @After("log()")
    public void  doAf(JoinPoint joinPoint){

        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("URL={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //class method
        logger.info("class-method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //args
        logger.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfReturn(Object object){
        logger.info("object={}", object);
    }




}
