package com.demo.querydsl.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class BlazePersistenceConfiguration {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  @Lazy(false)
  public CriteriaBuilderFactory criteriaBuilderFactory() {
    CriteriaBuilderConfiguration configuration = Criteria.getDefault();
    return configuration.createCriteriaBuilderFactory(entityManagerFactory);
  }

}
