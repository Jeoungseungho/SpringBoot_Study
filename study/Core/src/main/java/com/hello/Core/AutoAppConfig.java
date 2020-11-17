package com.hello.Core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter
)
public class AutoAppConfig {

}

