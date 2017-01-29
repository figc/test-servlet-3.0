package test.web;

import javax.servlet.ServletContext;


public class CustomWebAppInitializer implements WebAppInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {
		servletContext.log("onStartup for " + getClass().getName());
	}
}
