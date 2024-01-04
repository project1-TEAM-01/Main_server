package com.github.backend_1st_project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.nio.file.DirectoryStream;

@Configuration
public class EtagWebConfig {

@Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilterFilter(){
    FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(new ShallowEtagHeaderFilter());
    filterRegistrationBean.addUrlPatterns("/api/*");
    return filterRegistrationBean;
}

}
