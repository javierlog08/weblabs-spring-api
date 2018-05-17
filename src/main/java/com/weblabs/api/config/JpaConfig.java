package com.weblabs.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



/**
 * JPA wont detect repositories:
 * If you don't put @EnableRepositories on root package, for example com.weblabs.api, then you repositories wont be found by container scanner
 * so to get this work you need specify the package where yours repositories are...
 * @author Javier
 *
 */
@EnableJpaRepositories("com.weblabs.api.repositories") 
@Configuration
public class JpaConfig {}