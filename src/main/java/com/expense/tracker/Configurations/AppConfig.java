package com.expense.tracker.Configurations;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicates that this class contains one or more bean methods and may be
// processed by the Spring container to generate bean definitions and service requests.
public class AppConfig {

    private final BasicDataSource basicDataSource;

    @Bean // Indicates that this method produces a bean to be managed by the Spring container.
    public BasicDataSource dataSource() {
        return basicDataSource; // Returns the configured BasicDataSource bean.
    }

    @Autowired // Marks the constructor to be autowired by Spring's dependency injection facilities.
    public AppConfig(@Value("${datasource.url}") String url, // Injects the value of the 'datasource.url' property from the application properties file.
                     @Value("${datasource.username}") String username, // Injects the value of the 'datasource.username' property from the application properties file.
                     @Value("${datasource.password}") String password) // Injects the value of the 'datasource.password' property from the application properties file.
    {
        basicDataSource = new BasicDataSource(); // Creates a new instance of BasicDataSource.
        basicDataSource.setUrl(url); // Sets the URL for the data source.
        basicDataSource.setUsername(username); // Sets the username for the data source.
        basicDataSource.setPassword(password); // Sets the password for the data source.
    }
}
