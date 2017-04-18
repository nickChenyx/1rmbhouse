package com.rmbhouse.configer;

import com.rmbhouse.controller.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Created by Administrator on 2017/4/6.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rmbhouse.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping(){
        return new ControllerClassNameHandlerMapping();
    }
    @Bean
    public LoginController loginController(){
        return new LoginController();
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        // 模板位置
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // 设置编码，否则中文乱码
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        // 设置编码，否则中文乱码
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    /**
     * 配置静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("js/**").addResourceLocations("/js/");
        registry.addResourceHandler("css/**").addResourceLocations("/css/");
        registry.addResourceHandler("img/**").addResourceLocations("/img/");
        registry.addResourceHandler("images/**").addResourceLocations("/images/");
        registry.addResourceHandler("fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("plugins/**").addResourceLocations("/plugins/");
    }
}
