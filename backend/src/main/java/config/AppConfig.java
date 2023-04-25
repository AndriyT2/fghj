//package config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
////@EnableTransactionManagement
////@EnableJpaRepositories("repository")
////@ComponentScan(basePackages = {"repository", "service11", "osHibernate"})
////@PropertySource("classpath:application.properties")
//public class AppConfig {
//
//    @Autowired
//    Environment env;
////
////    @Bean
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
////        dataSource.setUrl(env.getProperty("spring.datasource.url"));
////        dataSource.setUsername(env.getProperty("spring.datasource.username"));
////        dataSource.setPassword(env.getProperty("spring.datasource.password"));
////        return dataSource;
////    }
////
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
////        LocalContainerEntityManagerFactoryBean em
////                = new LocalContainerEntityManagerFactoryBean();
////        em.setDataSource(dataSource());
////        em.setPackagesToScan("osHibernate", "service11", "repository");
////        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        em.setJpaVendorAdapter(vendorAdapter);
////
////        return em;
////    }
////
////    @Bean
////    public PlatformTransactionManager transactionManager() {
////        JpaTransactionManager transactionManager = new JpaTransactionManager();
////        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
////
////        return transactionManager;
////    }
// @Bean
//    public InternalResourceViewResolver resolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("tc/src/main/webapp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//        }
////#spring.mvc.view.prefix=/WEB-INF/jsp/
////#spring.mvc.view.suffix = .jsp
////}
