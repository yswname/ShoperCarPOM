package cn.com.demo.test;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class MyServletInitialzier implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic dynamic = ctx.addServlet("HelloServlet", HelloServlet.class);
        dynamic.addMapping("/helloServlet");
    }
}
