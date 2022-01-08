package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component  // < @Bean과 @Component의 차이 >
            // 1) @Bean : @Bean은 class에 붙일 수 없다. method에서 붙일 수 있다.
            // 2) @Component : @Component는 class에 붙일 수 있다. 하나의 class에 여러가지 bean이 등록이 된다.
public class TimerAop {

    // 첫번째 Pointcut : com.example.aop.controller 패키지 하위에 있는 모든 method에 걸겠다.
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")    // 규칙을 적어준다.
    private void cut(){}

    // 두번째 Pointcut : 해당 패키지 아래에 있는 @Timer annotation이 설정된 method에 걸겠다.
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")  // 제약을 걸었다.
    private void enableTimer(){}

    // 2. 실행시간 log를 확인해보자
    // : 시간을 잴 것이기 때문에 전후가 필요하다. 그래서 아까와 같이 @Before, @After가 있으면 타임을 공유할 수 없다.
    // -> 이럴때 @Around를 사용한다.

    @Around("cut() && enableTimer()")   // cut() 조건과 enableTimer() 조건을 같이 사용할 것이다.
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object result = joinPoint.proceed();    // proceed() : 실질적으로 메소드가 실행되는 것이다.
                                                // 메소드가 실행된 후, 리턴 값이 result에 리턴된다. 만약 void이면 result는 비어있게 된다.
        stopWatch.stop();

        System.out.println("total time : "+stopWatch.getTotalTimeSeconds());
    }

}
