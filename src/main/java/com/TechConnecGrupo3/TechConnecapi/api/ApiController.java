package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.dto.DataBody;
import com.TechConnecGrupo3.TechConnecapi.dto.DataPyme;
import com.TechConnecGrupo3.TechConnecapi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/data/{number}")
    public Mono<ResponseEntity<DataBody>> getDni(@PathVariable String number) {
        return apiService.getDniInfo(number)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pyme/{number}")
    public Mono<ResponseEntity<DataPyme>> getPyme(@PathVariable String number) {
        return apiService.getPymeInfo(number)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
