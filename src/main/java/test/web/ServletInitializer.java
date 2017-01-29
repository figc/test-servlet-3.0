package test.web;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@HandlesTypes(WebAppInitializer.class)
public class ServletInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> initializerClasses, ServletContext servletContext) throws ServletException {

 		servletContext.log("log from sc context");
		servletContext.log("loading spring servlet.....");
		
		
		if (initializerClasses != null) {
			WebAppInitializer initializer;
			for (Class<?> waiClass : initializerClasses) {
				if (waiClass != null && !waiClass.isInterface()) {
					System.out.println(waiClass);
					try {
						initializer = (WebAppInitializer) waiClass.newInstance();
						
						initializer.onStartup(servletContext);
					} catch (InstantiationException | IllegalAccessException e) {
						servletContext.log(e.getMessage());
					}
				}
			}
		}
		
		
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	    appContext.setConfigLocation("classpath:/spring/dispatcher-servlet.xml");
	    ServletRegistration.Dynamic dispatcher = servletContext.addServlet
	    	("dispatcher", new DispatcherServlet(appContext));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("*.html");
	}
}
