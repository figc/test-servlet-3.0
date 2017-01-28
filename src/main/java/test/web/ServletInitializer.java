package test.web;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@HandlesTypes()
public class ServletInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {

 		servletContext.log("log from sc context");
		servletContext.log("loading spring servlet.....");
		
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	    appContext.setConfigLocation("classpath:/spring/dispatcher-servlet.xml");
	    ServletRegistration.Dynamic dispatcher = servletContext.addServlet
	    	("dispatcher", new DispatcherServlet(appContext));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("*.html");
	}
}
