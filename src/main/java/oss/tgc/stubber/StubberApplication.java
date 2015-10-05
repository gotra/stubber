package oss.tgc.stubber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import oss.tgc.stubber.filters.SimpleCORSFilter;
import oss.tgc.stubber.model.StubInstance;
import oss.tgc.stubber.servlet.MainServlet;
import oss.tgc.stubber.servlet.ResourceServlet;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class StubberApplication extends SpringBootServletInitializer implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(StubberApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;




    @Bean
    public ServletRegistrationBean servlet1(){
        return new ServletRegistrationBean(new MainServlet(),"/*");
    }

    @Bean
    public ServletRegistrationBean servlet2(){
        return new ServletRegistrationBean(new ResourceServlet(),"/static/*");
    }

    @Bean
    public FilterRegistrationBean filterCORS() {
        FilterRegistrationBean newFilter = new FilterRegistrationBean(new SimpleCORSFilter());
        newFilter.addUrlPatterns("/*");
        return newFilter;
    }



    public static void main(String[] args) {
        SpringApplication.run(StubberApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {

//        log.info("Creating tables");
//
//
//
//        jdbcTemplate.query(
//                "SELECT name,description,urlpath,httpmethod,response FROM PUBLIC.STUBS", (Object[]) null,
//                (rs, rowNum) -> new StubInstance(rs.getString("name"), rs.getString("description"), rs.getString("urlpath"),rs.getString("httpmethod"),rs.getString("response"))
//        ).forEach(stubInstance -> log.info(stubInstance.toString()));
    }
}





