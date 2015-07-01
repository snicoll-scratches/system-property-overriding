package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(SampleProperties.class)
public class SampleApp {

    public static void main(String[] args) {
        System.setProperty("sample.the-name", "system property (same property name)");

        // While the first property works, this doesn't unless you remove
        // the value in application.properties (?!)
        //System.setProperty("SAMPLE_THE_NAME", "system property (relaxed)");
        SpringApplication.run(SampleApp.class, args);
    }


    @Service
    static class Startup {

        @Autowired
        SampleProperties sampleProperties;

        @PostConstruct
        public void displayValue() {
            System.out.println("-----> " + this.sampleProperties.getTheName());
        }

    }
}
