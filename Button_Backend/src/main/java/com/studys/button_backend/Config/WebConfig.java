package com.studys.button_backend.Config;

import com.studys.button_backend.Util.AdapterTypePhysicsButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdapterTypePhysicsButton adapter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adapter);
    }
}