package ca.horse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebApplicationInitializer is an interface provided by Spring MVC that ensures your code-based configuration 
 * is detected and automatically used to initialize any Servlet 3 container. An abstract base class implementation 
 * of this interface named AbstractAnnotationConfigDispatcherServletInitializer makes it even easier to register 
 * the DispatcherServlet by simply specifying its servlet mapping and listing configuration classes - it’s even 
 * the recommended way to set up your Spring MVC application
 * 
 * Great Explanation on ApplicationContext Hierarchies:
 * https://stackoverflow.com/questions/35258758/getservletconfigclasses-vs-getrootconfigclasses-when-extending-abstractannot
 * 
 * @author whkd2
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//let's dump AppConfig.class in here since we only have one dispatcher servlet
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	/**
	 * this can return null if all configurations done through getRotConfigClasses
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	/**
	 * specifies servlet mappings here
	 * Examples: "/example", "/example/ex/"
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { 
				"/" 
				};
	}

}
