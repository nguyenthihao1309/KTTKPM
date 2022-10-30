package com.example.onthigk.config;

import com.example.onthigk.filter.JWTFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class ConfigJWT {
    @Bean
    public FilterRegistrationBean<JWTFilter> registrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JWTFilter());
        filterRegistrationBean.addUrlPatterns("/users/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    ;
}
