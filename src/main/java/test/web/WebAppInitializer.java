package test.web;

import javax.servlet.ServletContext;

public interface WebAppInitializer {

	void onStartup(ServletContext servletContext);
}
