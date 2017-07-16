package mywrk.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MywrkWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// This will load data-tier and middle-tier dependencies.
		return new Class<?>[]{PropertyPlaceholderConfig.class,PersistenceConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// This will load spring web components like controllers, view resolvers and handlermappings
		return new Class<?>[]{WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// This will map DispatcherServlet to /
		return new String[]{"/"};
	}

}
