package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // AOP로 동작하기 위해서 적어주어야하는 annotation
@Component  // Spring에서 관리해야하기 때문에 이 annotation을 적어주었다.
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")    // 규칙을 적어준다. com.example.aop.controller 패키지 하위에 있는 모든 method를 aop로 보겠다라는 뜻
    private void cut(){}

    // 1. method parameter log를 확인해보자

    @Before("cut()")    // 메소드 cut()이 실행되는 지점의 @Before일 때 해당 메소드 before()을 실행시키겠다.
    public void before(JoinPoint joinPoint){

        // method의 이름은 joinPoint에서 가져올 수 있다.
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        // method 안에 들어가고 있는 argument
        Object[] args = joinPoint.getArgs();    // method에 들어가고 있는 argument들의 배열이다.
        for (Object obj : args){
            System.out.println("type : "+ obj.getClass().getSimpleName());  // argument의 type을 출력
            System.out.println("value : "+ obj);  // argument의 값을 출력

        }
    }

    @AfterReturning(value = "cut()", returning = "returnobj")
    public void afterReturn(JoinPoint joinPoint, Object returnobj){
        System.out.println("return obj");
        System.out.println(returnobj);  // return 하는 값 출력
    }

    // JoinPoint : 들어가는 지점에 대한 정보를 가진 객체
    // AfterReturning 같은 경우 object 객체를 parameter로 가진다.
}
