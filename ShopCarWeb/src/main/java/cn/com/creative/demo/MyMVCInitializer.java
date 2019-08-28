package cn.com.creative.demo;

import cn.com.creative.demo.config.SpringConfiguration;
import cn.com.creative.demo.config.SpringMVCConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 初始化SpringMVC环境
 *
 * 1 配置DispatcherServlet
 *   注册servlet 初始化的时候，加载springmvc-servlet.xml
 *   servlet mapping
 * 2 Spring的启动监听器
 * */
public class MyMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
