package com.rmbhouse.configer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Administrator on 2017/4/6.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("RootConfig");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("WebConfig");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);


        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter",new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding","UTF-8");
        encodingFilter.setInitParameter("forceEncoding","true");
        encodingFilter.addMappingForUrlPatterns(null,true,"/*");
    }
}
