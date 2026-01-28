package com.growvy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.ConfigurableApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.growvy")
public class GrowvyApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GrowvyApplication.class);
        ConfigurableApplicationContext context = app.run(args);
        System.out.println("Application started");

        DataSource ds = context.getBean(DataSource.class);
        try (Connection conn = ds.getConnection()) {
            System.out.println("DB Connection OK: " + conn.getMetaData().getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

