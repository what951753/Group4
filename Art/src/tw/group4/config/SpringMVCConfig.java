package tw.group4.config;

//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jndi.JndiObjectFactoryBean;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

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
	
	@Bean
	public InternalResourceViewResolver ViewResolver() {
		
//		一般的viewResolver設定
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
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
    public ViewResolver getViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
 
        // TilesView 3
        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(1);
        return viewResolver;
    }
 
//  設定Tiles設定檔放置路徑
    @Bean(name = "tilesConfigurer")
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
 
        // TilesView 3
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
 
        return tilesConfigurer;
    }
	
}
