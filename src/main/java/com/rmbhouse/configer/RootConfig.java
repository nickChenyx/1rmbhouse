package com.rmbhouse.configer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2017/4/6.
 */
@ComponentScan(basePackages = "com.rmbhouse",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)
})
@Configuration
public class RootConfig {
}
