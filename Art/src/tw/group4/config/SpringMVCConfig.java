package tw.group4.config;

import java.util.ArrayList;
import java.util.List;

//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jndi.JndiObjectFactoryBean;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import tw.group4.config.viewResolver.ExcelViewResolver;
import tw.group4.config.viewResolver.Jaxb2MarshallingXmlViewResolver;
import tw.group4.config.viewResolver.JsonViewResolver;
import tw.group4.config.viewResolver.PdfViewResolver;
import tw.group4.model.HouseBean;

//這個class設定SpringWebMVC和靜態資源對應網址還有視圖
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "tw.group4" )
//@PropertySource("classpath:jdbc.properties")
public class SpringMVCConfig implements WebMvcConfigurer {	
	
//	為了展示連線資訊設定的屬性
//	@Autowired
//	private Environment env;
	
	public SpringMVCConfig() {
		
	}
	
	//啟動DefaultServletHandling
	//印出jdbc.properties
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
//		addProperties();
	}
	
//	預設的jspViewResolver，設定去找指定實體路徑下的jsp檔返回畫面
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		
//		一般的viewResolver設定
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class); 先理解contentNegotiating，暫時不用
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		
		return viewResolver;
	}
	
////	JndiName名稱設定
//	@Bean
//	public DataSource getJndiObjectFactoryBean() {
//		JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
//		factoryBean.setJndiName("java:comp/env/jdbc/xe");
//		DataSource ds = (DataSource)factoryBean.getObject();
//		return ds;
//	}
//	
////	SessionFactory設定
//	@Bean(destroyMethod = "destroy")
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFacory = new LocalSessionFactoryBean();
//		sessionFacory.setDataSource(getJndiObjectFactoryBean());
//		sessionFacory.setPackagesToScan("tw.group4");
//		
//		Properties p1 = new Properties();
//		p1.put("hibernate.dialect", org.hibernate.dialect.Oracle12cDialect.class);
//		p1.put("hibernate.current_session_context_class", "thread");
//		p1.put("hibernate.show_sql", Boolean.TRUE);
//		p1.put("hibernate.format_sql", Boolean.TRUE);
//		
//		sessionFacory.setHibernateProperties(p1); 
//		
//	    return sessionFacory;
//	}
	
//	新增靜態資源對應網址
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
  	registry.addResourceHandler("/images/**")
    			.addResourceLocations("/WEB-INF/pages/images/");
    	registry.addResourceHandler("/css/**")
    			.addResourceLocations("/WEB-INF/pages/backstyle/css/");
    	registry.addResourceHandler("/vendor/**")
    			.addResourceLocations("/WEB-INF/pages/backstyle/vendor/");
    	registry.addResourceHandler("/js/**")
    	.addResourceLocations("/WEB-INF/pages/backstyle/js/");
  }
    
//  設定multipartResolver(傳輸多媒體檔案用)預設編碼UTF-8
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    
//  展示目前連到資料庫明細的方法
//	private void addProperties() {
//	String driverClassName = env.getRequiredProperty("datasource.driverClassName");
//	String url = env.getRequiredProperty("datasource.url");
//	String username = env.getRequiredProperty("datasource.username");
//	String password = env.getRequiredProperty("datasource.password");
//	
//	System.out.println("driverClassName:" + driverClassName);
//	System.out.println("url:" + url);
//	System.out.println("username:" + username);
//	System.out.println("password:" + password);
//}
    
//  設定Tiles的畫面產生順位
    @Bean(name = "tilesViewResolver")
    public ViewResolver tilesViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
 
        // TilesView 3
        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(1);
        return viewResolver;
    }
 
//  設定Tiles設定檔放置路徑
    @Bean(name = "tilesConfigurer")
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
 
        // TilesView 3
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
 
        return tilesConfigurer;
    }
    
//  設定ContentNegotiationManager，稍後設定ContentNegotiatingViewResolver會用到
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(
				MediaType.TEXT_HTML);
	}

//	設定ContentNegotiatingViewResolver，初步設定把檔案輸出格式對應的畫面
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

//		設定所有會用到contentNegotiating的viewResolver
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		
//		要加下面前兩行，否則無法用後綴詞副檔名啟用輸出格式
		resolvers.add(tilesViewResolver());
		resolvers.add(jspViewResolver());
		resolvers.add(jaxb2MarshallingXmlViewResolver());
		resolvers.add(jsonViewResolver());
		resolvers.add(pdfViewResolver());
		resolvers.add(excelViewResolver());
		
		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	/*
	 * Configure View resolver to provide XML output Uses JAXB2 marshaller to
	 * marshall/unmarshall POJO's (with JAXB annotations) to XML
	 */
	@Bean
	public ViewResolver jaxb2MarshallingXmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(HouseBean.class);
		return new Jaxb2MarshallingXmlViewResolver(marshaller);
	}

	/*
	 * Configure View resolver to provide JSON output using JACKSON library to
	 * convert object in JSON format.
	 */
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	/*
	 * Configure View resolver to provide PDF output using lowagie pdf library to
	 * generate PDF output for an object content
	 */
	@Bean
	public ViewResolver pdfViewResolver() {
		return new PdfViewResolver();
	}

	/*
	 * Configure View resolver to provide XLS output using Apache POI library to
	 * generate XLS output for an object content
	 */
	@Bean
	public ViewResolver excelViewResolver() {
		return new ExcelViewResolver();
	}
	
}
