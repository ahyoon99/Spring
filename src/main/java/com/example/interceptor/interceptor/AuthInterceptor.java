package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString()).build().toUri();

        log.info("request url : {}",url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 나의 서버는 모두 public으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키 등 뭔가를 보겠다!
        if(hasAnnotation){  // annotation을 가지고 있는 class이면 권한을 가지고 있는지 보겠다!
            // 권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            if(query.equals("name=steve")){
                return true;
            }
            throw new AuthException();
            //return false;
        }

        return true;   // false가 return되면 동작하지 않는다.
    }

    private boolean checkAnnotation(Object handler, Class clazz){  // annotation이 달려있는지 체크

        // resource : javascript, html 등 리소스에 대한 요청일 때는 무조건 통과시켜준다.
        if(handler instanceof ResourceHttpRequestHandler){
            return true;    // true는 통과를 의미한다.
        }

        // annotation 달려있는지 check
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null!= handlerMethod.getBeanType().getAnnotation(clazz)){
            // Auth annotation이 있을 때에는 true
            return true;
        }
        return false;
    }
}
