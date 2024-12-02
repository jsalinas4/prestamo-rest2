package com.TechConnecGrupo3.TechConnecapi.service;

import com.TechConnecGrupo3.TechConnecapi.dto.DataBody;
import com.TechConnecGrupo3.TechConnecapi.dto.DataPyme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    private final WebClient webClient;
    @Value("${api.token}")
    private String token;

    @Autowired
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<DataBody> getDniInfo(String number) {
        String url = "https://api.apis.net.pe/v2/reniec/dni?numero=" + number;

        return webClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(DataBody.class);
    }

    public Mono<DataPyme> getPymeInfo(String number) {
        String url = "https://api.apis.net.pe/v2/sunat/ruc?numero=" + number;

        return webClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(DataPyme.class);
    }
}