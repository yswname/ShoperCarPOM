package cn.com.creative.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
@Configuration
@EnableWebMvc//启动注解式的mvc
@ComponentScan(basePackages = "cn.com.creative.demo.web.controller")
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置不需要经过SpringMVC框架过滤的资源，比如js css 和 images等
        registry.addResourceHandler("/static/**").addResourceLocations(
                "/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //super.extendMessageConverters(converters);
        // 解决@ResponseBody乱码问题
        StringHttpMessageConverter httpConverter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        httpConverter.setSupportedMediaTypes(Arrays.asList(
                MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON,
                MediaType.TEXT_HTML));
        converters.add(0, httpConverter);// 需要添加到第一个，避免使用前面的msgConverter

        // 响应json
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        converters.add(jsonConverter);
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
// 注册视图转换器
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
}
