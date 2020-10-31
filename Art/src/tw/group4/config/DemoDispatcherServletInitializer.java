package tw.group4.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//地位等同web.xml，設定取代mvc-servlet.xml
public class DemoDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMVCJavaConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
//	設定request編碼的Filter
//	此寫法當web.xml和java config同時設定，會失去作用，要用方法二filter
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
	    
		return new Filter[] {encodingFilter};
	}
	
//	設定request編碼的方法二filter
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//	      FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
//	      encodingFilter.setInitParameter("encoding", "UTF-8");
//	      encodingFilter.setInitParameter("forceEncoding", "true");
//	      encodingFilter.addMappingForUrlPatterns(null, true, "/*");
//	}

}
