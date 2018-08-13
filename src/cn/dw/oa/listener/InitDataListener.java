package cn.dw.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.dw.oa.model.Category;
import cn.dw.oa.service.CategoryService;

public class InitDataListener implements ServletContextListener {
	
	private CategoryService categoryService;
	
	private ApplicationContext context;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
		categoryService = context.getBean("cs",CategoryService.class);
		List<Category> catList = categoryService.queryByName("");
		application.setAttribute("catList", catList);
	}	

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	}

}
