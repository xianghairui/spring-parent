package com.xiang.spring.struts2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringServletContextListener
 *
 */
// @WebListener
public class SpringServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SpringServletContextListener() {
    }

	@Override
	public void contextInitialized(ServletContextEvent args) {
		// 获取Spring 文件的名称
		ServletContext servletContext = args.getServletContext();
		String configLocation = servletContext.getInitParameter("configLocation");

		// 1. 创建 IOC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		
		// 2. 把 IOC 容器放在 ServletContext 的一个属性中
		servletContext.setAttribute("ApplicationContext", ctx);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}

