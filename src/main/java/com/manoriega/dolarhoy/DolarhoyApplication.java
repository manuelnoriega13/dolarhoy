package com.manoriega.dolarhoy;

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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEncryptableProperties
@PropertySource(name="EncryptedProperties", value = "classpath:encrypted.properties")
@EnableScheduling
@Configuration
public class DolarhoyApplication extends SpringBootServletInitializer implements CommandLineRunner {
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
        uiSwing.init();
//        SpringApplication.run(DolarhoyApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(DolarhoyApplication.class);



    }

    @Override
    public void run(String... args) throws Exception {
//        ui.init();
//        UI ui = appContext.getBean(UI.class);
//        ui.init();

    }
}
