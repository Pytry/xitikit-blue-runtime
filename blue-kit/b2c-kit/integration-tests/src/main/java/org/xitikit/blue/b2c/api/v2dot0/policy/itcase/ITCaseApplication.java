package org.xitikit.blue.b2c.api.v2dot0.policy.itcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xitikit.blue.boot.b2c.SimplePolicyConfiguration;

/**
 * Created by Keith on 10/15/2017.
 */
@SpringBootApplication
public class ITCaseApplication{

    public static void main(final String[] args){

        SpringApplication.run(ITCaseApplication.class, args);
    }

    @Bean
    public static SimplePolicyConfiguration policyConfiguration(){

        return new SimplePolicyConfiguration();
    }
}