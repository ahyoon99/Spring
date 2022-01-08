package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

// < 값의 변환 = parameter encode >
// 암호화된 값이 들어오거나 필터, 인터셉터등 변환을 하려고 할 때
// 톰캣 자체에서 한번 바디를 읽으면 더이상 읽을 수 없도록 막아놓았기 때문에 변환하기가 어렵다.
// 하지만 aop같은 구간에서는 이미 필터, 인터셉터를 지나서 값 자체가 객체화 되었기 때문에
// 그 값을 변환해주거나 aop에서 특정한 객체를 넣어줄 수 있다.
// 그렇다보니 외부에서 암호화된 파일이나 필드가 들어올때 코드에서 복호화하는게 아니라
// 이미 aop 단계에서 복호화가 완료된 상태로 들어오게 할 수 있다
// 또한 밖으로 내보낼때 내부 코드에서는 일반적으로 코딩하지만
// 특정 회원사 또는 특정 서버에게 보낼 때에는 aop단에서 변경시켜줄수록 할 수 있다.
@Aspect
@Component
public class DecodeAop {

    // 첫번째 Pointcut : com.example.aop.controller 패키지 하위에 있는 모든 method에 걸겠다.
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")    // 규칙을 적어준다.
    private void cut(){}

    // 두번째 Pointcut : 해당 패키지 아래에 있는 @Decode annotation이 설정된 method에 걸겠다.
    @Pointcut("@annotation(com.example.aop.annotation.Decode)")  // 제약을 걸었다.
    private void enableDecode(){}

    // 3. Parameter Encode

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();    // method에 들어가고 있는 argument들의 배열이다.

        for(Object arg : args){
            if(arg instanceof User) {    // arg의 instance가 User이면
                // decode
                User user = User.class.cast(arg);   // arg를 User로 형변환 시킨다.
                String base64Email = user.getEmail();// base64로 encoding되어 있던 email을 꺼낸다.
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");     // decode을 해준다.
                user.setEmail(email);
                // -> 실질적인 controller 코드에서는 User라는 객체를 decode할 일이 없게 된다.
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof User){
            // encode
            User user = User.class.cast(returnObj);   // returnObj를 User로 형변환 시킨다.
            String email = user.getEmail(); // 평문 이메일이다.
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());  // encode를 해준다.
            user.setEmail(base64Email);
        }
    }
}
