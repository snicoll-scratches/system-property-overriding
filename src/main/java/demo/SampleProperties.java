package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Stephane Nicoll
 */
@ConfigurationProperties("sample")
public class SampleProperties {

    private String theName = "in code";

    public String getTheName() {
        return theName;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }
}
