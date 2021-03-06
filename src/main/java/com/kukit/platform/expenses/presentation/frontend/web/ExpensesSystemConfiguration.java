package com.kukit.platform.expenses.presentation.frontend.web;

import com.kukit.platform.expenses.application.ExpensesSystem;
import com.kukit.platform.expenses.infrastructure.ExpensesRepository;
import com.kukit.platform.expenses.infrastructure.ProductionRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.expenses.infrastructure")
@EntityScan(basePackages = {"com.example.expenses.domain"})
class ExpensesSystemConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ProductionRepository productionRepository(ExpensesRepository expensesRepository){
        return new ProductionRepository(expensesRepository);
    }

    @Bean
    public ExpensesSystem registrationSystem(ProductionRepository productionRepository) {
        return com.kukit.platform.expenses.application.ExpensesSystemConfiguration
                .expensesSystem(productionRepository);
    }

}
