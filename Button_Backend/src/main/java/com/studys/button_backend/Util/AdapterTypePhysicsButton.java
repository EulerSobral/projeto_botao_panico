package com.studys.button_backend.Util;


import com.studys.button_backend.Interface.AdapterInterface;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AdapterTypePhysicsButton implements AdapterInterface, HandlerInterceptor {
    private final AtomicInteger postTestRequestCounter = new AtomicInteger(0);
    private static final String TARGET_URI = "/Alert";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod()) && TARGET_URI.equals(request.getRequestURI())) {
            int count = postTestRequestCounter.incrementAndGet();
            System.out.println("Interceptado POST para /Alert. Contador = " + count);
        }
        return true;
    }

    @Override
    public String getType(){
        if(getPostTestRequestCount() == 1){
            return "Alerta";
        }else if(getPostTestRequestCount() == 2){
            return "Bombeiros";
        }
        return "Policia";
    }

    public int getPostTestRequestCount() {
        return postTestRequestCounter.get();
    }
}
