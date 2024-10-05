package com.misc.petsworld;

import com.example.client.ApiClient;
import com.example.client.api.PetApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetStoreIntegrationConfig {

    @Bean
    public PetApi petApi() {
        return new PetApi(apiClient());
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }
}
