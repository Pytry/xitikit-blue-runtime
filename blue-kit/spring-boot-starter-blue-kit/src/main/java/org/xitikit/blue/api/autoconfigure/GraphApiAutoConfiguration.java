package org.xitikit.blue.api.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright Xitikit.org 2017
 *
 * @author J. Keith Hoopes on 5/4/2017.
 */
@Configuration
@AutoConfigureAfter(B2CPropertiesAutoConfiguration.class)
public class GraphApiAutoConfiguration{

}
