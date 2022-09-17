package com.mezzoforte.greenstreet.global.interceptor;

import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
import com.mezzoforte.greenstreet.global.annotation.AuthorizationCheck;
import com.mezzoforte.greenstreet.global.error.exception.CredentialsNotFoundException;
import com.mezzoforte.greenstreet.global.lib.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final Jwt jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        if(request.getMethod().equals("OPTIONS")) return true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthorizationCheck authorizationAnnotation = handlerMethod.getMethodAnnotation(AuthorizationCheck.class);

        if (authorizationAnnotation == null) {
            return true;
        }

        String token = jwt.extract(request, "Bearer");

        if (token == null || token.length() == 0) {
            throw CredentialsNotFoundException.EXCEPTION;
        }

        User user = jwt.validateToken(token);
        request.setAttribute("user", user);
        return true;
    }
}
