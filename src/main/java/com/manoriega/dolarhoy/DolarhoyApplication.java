package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.config.SwaggerConfig;
import com.manoriega.dolarhoy.controller.swing.UI;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;
import java.io.IOException;


@SpringBootApplication
@EnableEncryptableProperties
@PropertySource(name = "EncryptedProperties", value = "classpath:encrypted.properties")
@EnableScheduling
@Configuration
@Import(SwaggerConfig.class)
public class DolarhoyApplication extends SpringBootServletInitializer implements CommandLineRunner, WebMvcConfigurer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

//    @Autowired
//    private UI ui;

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(DolarhoyApplication.class).headless(false).run(args);
        UI uiSwing = context.getBean(UI.class);
        try {
            uiSwing.trayIcon();
        } catch (InterruptedException | AWTException | IOException e) {
            e.printStackTrace();
        }
//        SpringApplication.run(DolarhoyApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(DolarhoyApplication.class);


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void run(String... args) throws Exception {
//        ui.init();
//        UI ui = appContext.getBean(UI.class);
//        ui.init();

    }
}
